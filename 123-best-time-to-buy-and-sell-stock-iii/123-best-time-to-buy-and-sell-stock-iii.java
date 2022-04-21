class Solution {
    private int mp(int[] prices,int ind, int buy,int noOfTrans,int dp[][][] ){
        if(noOfTrans<0 || ind==prices.length) return 0;
        
        if(dp[ind][buy][noOfTrans]!=-1) return dp[ind][buy][noOfTrans];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[ind]+mp(prices,ind+1,0,noOfTrans-1,dp),
                           mp(prices,ind+1,1,noOfTrans,dp));
        }
        else{
            profit=Math.max(prices[ind]+mp(prices,ind+1,1,noOfTrans-1,dp),
                           mp(prices,ind+1,0,noOfTrans,dp));
        }
        return dp[ind][buy][noOfTrans]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][] = new int[n][2][5];
        for(int row[][]:dp)
            for(int r[]:row)
                Arrays.fill(r,-1);
        return mp(prices,0,1,4,dp);
    }
}