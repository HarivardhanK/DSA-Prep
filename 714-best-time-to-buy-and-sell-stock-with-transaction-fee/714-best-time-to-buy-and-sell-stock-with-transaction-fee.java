class Solution {
        private int solve(int[] prices, int ind,int fee, int isbuy, int dp[][]){
        
        if(ind==prices.length) return 0;
        
        if(dp[ind][isbuy]!=-1) return dp[ind][isbuy];
        int pick = (int)-1e9, nopick = (int)-1e9;
        if(isbuy==0){
            pick = Math.max( -prices[ind] + solve(prices, ind+1,  fee, 1,dp),solve(prices, ind+1,  fee, 0,dp));
        }
        else{
            nopick = Math.max(prices[ind] + solve(prices, ind+1, fee, 0,dp) - fee, solve(prices, ind+1,  fee, 1,dp));
        }
        return dp[ind][isbuy] = Math.max(pick, nopick);
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int r[]:dp)
        Arrays.fill(r,-1);
        return solve(prices, 0, fee, 0,dp);
    }
}