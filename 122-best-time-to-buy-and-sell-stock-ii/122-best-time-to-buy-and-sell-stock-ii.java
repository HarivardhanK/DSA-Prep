class Solution {
    private int mp(int[] prices, int ind, int buy, int dp[][]){
        if(ind==prices.length) return 0;
        
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit = 0;
        if(buy==1){
            profit=Math.max(-prices[ind]+mp(prices,ind+1,0,dp),
                           mp(prices,ind+1,1,dp));
        }
        else{
            profit=Math.max(prices[ind]+mp(prices,ind+1,1,dp),
                           mp(prices,ind+1,0,dp));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][] = new int[n][2];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        //0-notbut & 1-buy
        return mp(prices,0,1,dp);
    }
}