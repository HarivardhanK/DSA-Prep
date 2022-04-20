class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        boolean prev[] = new boolean[m+1];
        prev[0] = true;
        
        for(int j=1;j<=m;j++){
            boolean flag = true;
            for(int ind=j;ind>0;ind--){
                if(p.charAt(ind-1)!='*'){
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }
        for(int i=1;i<=n;i++){
            boolean curr[] = new boolean[m+1];
            curr[0] = false;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    curr[j] = prev[j-1];
                else if(p.charAt(j-1)=='*')
                    curr[j] = prev[j] || curr[j-1];
                else
                    curr[j] = false;
            }
            prev=curr;
        }
        return prev[m];
    }
}