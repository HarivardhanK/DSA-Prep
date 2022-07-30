class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] map = new int[26];
        int max = 0;
        for(String word: words2) {
            max = Math.max(max, word.length());
            int[] m = new int[26];
            for(char ch: word.toCharArray()) {
                m[ch - 'a']++;
            }
            
            for(int i = 0; i < 26; i++) {
                map[i] = Math.max(map[i], m[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(String word: words1) {
            if(max <= word.length()) {
                int[] m = map.clone();
                if(match(word, m)) {
                    ans.add(word);
                }
            }
        } 
        
        return ans;
    }
    boolean match(String word, int[] m) {
        for(char ch: word.toCharArray()) {
            if(m[ch - 'a'] > 0) 
                m[ch - 'a']--;
        }
        for(int ele: m) 
            if(ele != 0)
                return false;
        return true;
    }
}