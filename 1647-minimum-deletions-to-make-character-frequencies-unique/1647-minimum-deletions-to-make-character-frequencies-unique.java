class Solution {
    public int minDeletions(String s) {
        //mapping the character's with their frequencies/occurences
        Integer[] map = new Integer[26];
        Arrays.fill(map, 0);
        for(char ch: s.toCharArray()) {
            map[ch - 'a']++;
        }
        
        //sorting according to the frequencies in decreasing order
        Arrays.sort(map, Collections.reverseOrder());
        
        int maxFreq = map[0], mindels = 0;
        for(int i: map) {
            
            if(i == 0) break;
            
            if(i > maxFreq) {
                if(maxFreq > 0)
                    mindels += (i - maxFreq);
                else 
                    mindels += i;
            }
            maxFreq = Math.min(maxFreq - 1, i - 1);
        }
        return mindels;
    }
}

/*
    "aaabbbc"
    {a-3, b-3, c-1} 
    lastCount = 3
    
    
*/