class Solution {
    private boolean ism(String s, String p, int i, int j,int dp[][]){
        if(i==0 && j==0) return true;
        if(j==0 && i>0) return false;
        if(i==0 && j>0){
            for(int ind=j;ind>0;ind--){
                if(p.charAt(ind-1)!='*') return false;
            }
            return true;
        }
        
        if(dp[i][j]!=-1) return dp[i][j]==0?false:true;
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
            boolean ans =  ism(s,p,i-1,j-1,dp);
            dp[i][j] = (ans)?1:0;
            return ans;
        }
        else if(p.charAt(j-1)=='*'){
            boolean ans =  ism(s,p,i,j-1,dp) || ism(s,p,i-1,j,dp);
            dp[i][j] = (ans)?1:0;
            return ans;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return ism(s,p,n,m,dp);
    }
}