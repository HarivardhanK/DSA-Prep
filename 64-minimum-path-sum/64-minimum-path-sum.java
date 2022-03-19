class Solution {
    int minPath(int[][] grid, int r, int c, int[][] dp){
        if(r==grid.length-1 && c==grid[0].length-1) return grid[r][c];
        if(r>grid.length-1 || c>grid[0].length-1) return Integer.MAX_VALUE;
        if(dp[r][c]==-1){
            dp[r][c] = grid[r][c]+Math.min(minPath(grid, r+1, c, dp),minPath(grid, r, c+1, dp));
        }
        return dp[r][c];
    }
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int row[]:dp) Arrays.fill(row,-1);
        return minPath(grid, 0, 0,dp);
    }
}