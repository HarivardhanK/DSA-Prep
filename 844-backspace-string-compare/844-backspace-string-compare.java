class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1;
        int skipi=0,skipj=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    skipi++; i--;
                }
                else if(skipi>0){
                    skipi--; i--;
                }
                else break;
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    skipj++; j--;
                }
                else if(skipj>0){
                    skipj--; j--;
                }
                else break;
            }
            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j)) return false;
            
            if(i>=0 != j>=0) return false;
            i--;j--;
        }
        return true;
    }
}