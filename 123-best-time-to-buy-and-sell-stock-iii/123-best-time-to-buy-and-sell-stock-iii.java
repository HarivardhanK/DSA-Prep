class Solution {
    private int mp(int[] prices,int ind,int noOfTrans,int dp[][] ){
        if(noOfTrans>4 || ind==prices.length) return 0;
        
        if(dp[ind][noOfTrans]!=-1) return dp[ind][noOfTrans];
        int profit=0;
        if(noOfTrans%2==0){
            profit=Math.max(-prices[ind]+mp(prices,ind+1,noOfTrans+1,dp),
                           mp(prices,ind+1,noOfTrans,dp));
        }
        else{
            profit=Math.max(prices[ind]+mp(prices,ind+1,noOfTrans+1,dp),
                           mp(prices,ind+1,noOfTrans,dp));
        }
        return dp[ind][noOfTrans]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][] = new int[n+1][5];
        Arrays.fill(dp[n],0);
        for(int i=0;i<=n;i++)
            dp[i][4]=0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=3;j>=0;j--){
                if(j%2==0){
                    dp[i][j]=Math.max(-prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                else{
                    dp[i][j]=Math.max(prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }
            }
        }
            
        return dp[0][0];
    }
}