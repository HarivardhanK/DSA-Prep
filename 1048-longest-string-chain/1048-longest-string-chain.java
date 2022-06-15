class Solution {
    public int longestStrChain(String[] words) {
        int res = 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String w: words) {
            map.put(w, 1);
            for(int i = 0; i < w.length(); i++) {
                String s = w.substring(0,i) + w.substring(i+1, w.length());
                if(map.containsKey(s) && map.get(s) + 1 > map.get(w)) 
                    map.put(w, map.get(s) + 1);
            }
            res = Math.max(res, map.get(w));
        }
        return res;
    }
}