class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] isEveryCharAppearing = new boolean[26];
        for(char ch: sentence.toCharArray()) 
            isEveryCharAppearing[ch-'a'] = true;
        
        boolean ans = true;
        for(boolean val: isEveryCharAppearing) ans &= val;
        return ans;
    }
}