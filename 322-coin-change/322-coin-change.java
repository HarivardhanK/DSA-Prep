class Solution {
    private int solve(int[] coins, int i, int target, int dp[][]){
        if(i==0){
            if(target%coins[i]==0) return target/coins[i];
            else return (int)1e9;
        }
        if(target==0) return 0;
        if(dp[i][target]!=-1) return dp[i][target];
        int pick = (int)1e9, nonpick;
        nonpick = solve(coins, i-1, target, dp);
        if(target>=coins[i])
            pick = 1+solve(coins, i, target - coins[i], dp);
        
        return dp[i][target] = Math.min(pick,nonpick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        int result = solve(coins, n-1, amount,dp);
        return result == (int)1e9?-1:result;
    }
}