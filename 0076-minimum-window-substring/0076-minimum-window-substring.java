class Solution {
    private boolean valid(Map<Character, Integer> mapt, Map<Character, Integer> maps) {
        for(Map.Entry<Character, Integer> en: mapt.entrySet()) {
            char ch = en.getKey();
            if(!maps.containsKey(ch) || maps.get(ch) < en.getValue()) 
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapt = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();
        
        for(char ch: t.toCharArray()) 
            mapt.put(ch, mapt.getOrDefault(ch, 0)+1);
        
        int ans = (int)1e9, st = 0, en = s.length()-1;
        int p1 = 0, p2 = 0;
        
        while(p1 <= p2) {
            if(valid(mapt, maps)) {
                if(ans > (p2-p1+1)) {
                    ans = p2-p1+1;
                    st = p1;
                    en = Math.min(p2-1, s.length()-1);
                }
                maps.put(s.charAt(p1), maps.get(s.charAt(p1))-1);
                p1++;
            }
            else if(p2 < s.length()) {
                maps.put(s.charAt(p2), maps.getOrDefault(s.charAt(p2), 0)+1);
                p2++;
            }
            else break;
        }
        return (ans == (int)1e9)?"":s.substring(st, en+1);
    }
}