class Solution {
    private int solve(int[] prices, int ind, int isbuy, int dp[][]){
        
        if(ind>=prices.length) return 0;
        if(dp[ind][isbuy]!=-1) return dp[ind][isbuy];
        int pick = (int)-1e9, nopick = (int)-1e9;
        if(isbuy==0){
            pick = Math.max( -prices[ind] + solve(prices, ind+1, 1,dp),solve(prices, ind+1, 0,dp));
        }
        else{
            nopick = Math.max(prices[ind] + solve(prices, ind+1, 0,dp), solve(prices, ind+1, 1,dp));
        }
        return dp[ind][isbuy] = Math.max(pick, nopick);
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int r[] : dp)
            Arrays.fill(r,-1);
        // 0 buy 1 sell
        return solve(prices, 0, 0, dp);
    }
}