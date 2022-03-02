class Solution {
    public boolean isSubsequence(String s, String t) {
        int sind=0,tind=0;
        while(sind<s.length() && tind<t.length()){
            if(s.charAt(sind)==t.charAt(tind)) sind++;
            tind++;
        }
        if(sind!=s.length()) return false;
        return true;
    }
}