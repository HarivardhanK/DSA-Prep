class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words =s.split(" ");
        
        if(words.length != pattern.length()) return false;
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Boolean> map2 = new HashMap<>();
        int j=0;
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(!map1.containsKey(ch)){
                if(map2.containsKey(words[j])) return false;
                else{
                    map1.put(ch,words[i]);
                    map2.put(words[i],true);
                }
            }      
            else{
                if(!words[j].equals(map1.get(ch))) return false;
            }
            j++;
        }
        return true;
    }
}