class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        boolean flag = true;
        
        for(String word: words) {
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> m = new HashMap<>();
            flag = true;
            for(int i = 0; i < word.length(); i++) {
                if(!map.containsKey(pattern.charAt(i))) {
                    map.put(pattern.charAt(i), word.charAt(i));
                }
                else {
                    if(map.get(pattern.charAt(i)) != word.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                
                if(!m.containsKey(word.charAt(i))) {
                    m.put(word.charAt(i), pattern.charAt(i));
                }
                else {
                    if(m.get(word.charAt(i)) != pattern.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) ans.add(word);   
        }
        return ans;
    }
}