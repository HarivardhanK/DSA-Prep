class Solution {
    private int solve(int[] prices, int k,int i, int noOfTrans, int[][] dp) {
        if(k == noOfTrans/2 || i == prices.length) return 0;
        
        if(dp[i][noOfTrans] != -1) return dp[i][noOfTrans];
        
        if(noOfTrans%2 == 0) {
            return dp[i][noOfTrans] = Math.max(solve(prices, k, i+1, noOfTrans+1, dp)-prices[i],
                           solve(prices, k, i+1, noOfTrans, dp));
        }
        else {
            return dp[i][noOfTrans] = Math.max(prices[i]+solve(prices, k, i+1, noOfTrans+1, dp),
                           solve(prices, k, i+1, noOfTrans, dp));
        }
        
    }
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2*k];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(prices, k, 0, 0, dp);
    }
}