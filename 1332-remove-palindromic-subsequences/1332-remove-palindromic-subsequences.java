class Solution {
    private boolean palin(String s) {
        int sind = 0, eind = s.length() - 1;
        while(sind < eind) {
            if(s.charAt(sind) != s.charAt(eind)) {
                return false;
            }
            sind++; eind--;
        }
        return true;
    }
    public int removePalindromeSub(String s) {
        boolean ispalin = palin(s);
        if(ispalin) {
            return 1;
        }
        return 2;
    }
}