class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);
        
        int len = words[0].length();
        for(int i = 0; i <= s.length() - len*words.length; i++) {
            Map<String, Integer> cmap = new HashMap<>(map);
            int count = words.length;
            for(int j = 0; j < words.length; j++) {
                String str = s.substring(i + j*len, i + j*len + len);
                if(cmap.containsKey(str) && cmap.get(str) > 0) {
                    cmap.put(str, cmap.get(str) - 1);
                    count--;
                }
                else break;
            }
            if(count == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

//barfoothefoobarman

//[foo, bar]