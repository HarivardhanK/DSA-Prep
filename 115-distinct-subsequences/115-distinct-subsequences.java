class Solution {
    private int nd(String s, String t, int i, int j,int dp[][]){
        //base case
        if(j==0) return 1;
        if(i==0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        //exploring all possible cases
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=nd(s,t,i-1,j-1,dp)+nd(s,t,i-1,j,dp);
        }
        return dp[i][j] = nd(s,t,i-1,j,dp);
    }
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return nd(s,t,n,m,dp);
    }
}