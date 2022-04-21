class Solution {
    private int mp(int[] prices,int ind,int buy, int[][] dp){
        if(ind>=prices.length) return 0;
        
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][buy]=Math.max(-prices[ind]+mp(prices,ind+1,0,dp),mp(prices,ind+1,1,dp));
        }
        else{
            return dp[ind][buy]=Math.max(prices[ind]+mp(prices,ind+2,1,dp),mp(prices,ind+1,0,dp));
        }
    }
    public int maxProfit(int[] prices) {
        //sell-0, buy-1 , cooldown - 2 
        int n=prices.length;
        int [][]dp = new int[n][2];
        for(int row[]:dp) Arrays.fill(row,-1);
        return mp(prices,0,1,dp);   
    }
}