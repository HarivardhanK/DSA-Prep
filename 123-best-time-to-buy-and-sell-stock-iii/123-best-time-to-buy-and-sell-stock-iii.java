class Solution {
    private int solve(int[] prices, int ind, int isbuy, int dp[][]){
        
        if(ind==prices.length || isbuy==4) return 0;
        if(dp[ind][isbuy]!=-1) return dp[ind][isbuy];
        int pick = (int)-1e9, nopick = (int)-1e9;
        if(isbuy%2 == 0){
            pick = Math.max( -prices[ind] + solve(prices, ind+1, isbuy+1,dp),solve(prices, ind+1, isbuy,dp));
        }
        else{
            nopick = Math.max(prices[ind] + solve(prices, ind+1, isbuy+1,dp), solve(prices, ind+1, isbuy,dp));
        }
        return dp[ind][isbuy] = Math.max(pick, nopick);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][]=  new int[n][4];
        for(int r[] : dp)
            Arrays.fill(r, -1);
        return solve(prices, 0 , 0, dp);
    }
}