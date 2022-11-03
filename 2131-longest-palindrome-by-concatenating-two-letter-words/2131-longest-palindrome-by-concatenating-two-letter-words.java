class Solution {
    public int longestPalindrome(String[] words) {
        //word, freq
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        boolean flag = false;
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        for(Map.Entry<String, Integer> en: map.entrySet()) {
            int freq = en.getValue();
            String w = en.getKey();
            String rev = new StringBuilder(w).reverse().toString();
            if(w.equals(rev)) {
                ans += (freq/2)*4;
                if(!flag && freq%2 == 1) {ans+=2; flag = true;}
            }
            else if(map.containsKey(rev)) {
                ans += Math.min(map.get(rev), freq)*4;
                map.put(rev, 0);
            }
        }
        return ans;
    }
}
