class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morsecode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word : words) {
            String mc = "";
            for(char ch: word.toCharArray()) {
                mc+=morsecode[ch - 'a'];
            }
            if(mc != "")
                set.add(mc);
        }
        return set.size();
    }
}