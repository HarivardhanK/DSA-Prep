class Solution {
    private int mincost(int[] cost, int i, int[] dp){
        if(i==0 || i==1) return cost[i];
        if(dp[i]!=-1) return dp[i];
        int onestep =mincost(cost,i-1,dp);
        int twostep = mincost(cost,i-2,dp);
        return dp[i] = cost[i]+Math.min(onestep,twostep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return Math.min(mincost(cost,n-1,dp),mincost(cost,n-2,dp));
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}