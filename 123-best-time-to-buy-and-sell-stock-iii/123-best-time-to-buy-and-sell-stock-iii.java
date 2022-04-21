class Solution {
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