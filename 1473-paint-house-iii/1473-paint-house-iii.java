class Solution {
    int MAX = (int)1e9;
    
    private int solve(int[] houses, int[][] cost, int i, int lastColor, int target, int c, int[][][] dp) {
        if(target < 0) 
            return MAX;
        
        if(i >= houses.length) 
            return (target == 0)?0:MAX;
        
        if(dp[i][lastColor][target] != -1) 
            return dp[i][lastColor][target];
        
        
        
        if(houses[i] != 0) {
            if(houses[i] != lastColor) 
                target = target - 1;
            return solve(houses, cost, i + 1, houses[i], target, c, dp);
        }
        
        int mincost = MAX;
        for(int color = 1; color <= c; color++) {
            int ans = cost[i][color - 1] + solve(houses, cost, i + 1, color, target - ((lastColor != color)? 1 :0), c, dp);
            
            mincost = Math.min(mincost, ans);
        }
        
        return dp[i][lastColor][target] = mincost;
    }
    public int minCost(int[] houses, int[][] cost, int h, int c, int target) {
        int[][][] dp = new int[h+1][c+1][target+1];
        
        for(int[][] row: dp) 
            for(int[] r: row) 
                Arrays.fill(r, -1);
        
        int ans = solve(houses, cost, 0, 0, target, c, dp);
        
        return (ans == MAX)?-1:ans;
    }
}