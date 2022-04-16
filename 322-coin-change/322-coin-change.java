class Solution {
    public int coinChange(int[] coins, int tar) {
        int n=coins.length;
        int dp[][] = new int[coins.length][tar+1];
        for(int i=0;i<=tar;i++)
            if(i%coins[0]==0) 
                dp[0][i] = i/coins[0];
            else
                dp[0][i]=(int)1e9;
        for(int i=1;i<n;i++){
            for(int k=0;k<=tar;k++){
                int nopick=dp[i-1][k];
                int pick = (int)1e9;
                if(coins[i]<=k) pick = 1+dp[i][k-coins[i]];
                dp[i][k] = Math.min(pick,nopick);
            }
        }
        return dp[n-1][tar]==1e9?-1:dp[n-1][tar];
    }
}