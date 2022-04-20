class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++) dp[i][0] = false;
        for(int j=1;j<=m;j++){
            boolean flag = true;
            for(int ind=j;ind>0;ind--){
                if(p.charAt(ind-1)!='*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}