class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int ans = 0;
        
        for(char ch: s.toCharArray()) {
            map.putIfAbsent(ch, new LinkedList<>());
        }
        
        for(String word: words) {
            char startchar = word.charAt(0);
            if(map.containsKey(startchar)) {
                map.get(startchar).add(word);
            }
        }
        
        for(char ch: s.toCharArray()) {
            Queue<String> q = map.get(ch);
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if(word.substring(1).length() == 0) {
                    ans++;
                }
                else if(map.containsKey(word.charAt(1))) {
                    map.get(word.charAt(1)).add(word.substring(1));
                }
            }
        }
        return ans;
    }
}