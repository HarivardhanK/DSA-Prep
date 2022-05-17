class Solution {
    private int solve(int[] prices, int ind, int isbuy, int dp[][]){
        
        if(ind==prices.length) return 0;
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
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        // for(int r[] : dp)
        //     Arrays.fill(r,-1);
        // 0 buy 1 sell
        // return solve(prices, 0, 0, dp);
        for(int ind=n-1;ind>=0;ind--){
            for(int isbuy=0;isbuy<=1;isbuy++){
                int pick = (int)-1e9, nopick = (int)-1e9;
                if(isbuy==0){
                    pick = Math.max( -prices[ind] + dp[ind+1][1],dp[ind+1][0]);
                }
                else{
                    nopick = Math.max(prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                }
                dp[ind][isbuy] = Math.max(pick, nopick);
            }
        }
        return dp[0][0];
    }
}