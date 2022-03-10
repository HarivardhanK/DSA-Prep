class Solution {
    public int climbstairsHelper(int n,int[] dp){
        if(n<0) return 0;
        if(n==0 || n==1){
            dp[n]=1;
            return dp[n];
        }
        if(dp[n-1]==-1 && dp[n-2]==-1)
            dp[n]= climbstairsHelper(n-1,dp)+climbstairsHelper(n-2,dp);
        else
            dp[n]=dp[n-1]+dp[n-2];
        return dp[n];
    }
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbstairsHelper(n,dp);
    }
}