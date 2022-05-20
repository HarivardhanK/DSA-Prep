class Solution {
    private int solve(int[][] grid, int r, int c, int dp[][]){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==1) return 0;
        if(r==grid.length-1 && c==grid[0].length-1) return 1;
        
        if(dp[r][c]!=-1) return dp[r][c];
        
        int count = solve(grid, r+1, c,dp);
        count += solve(grid, r, c+1,dp);
        return dp[r][c] = count;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int dp[][] = new int[m][n];
        for(int row[]:dp) 
            Arrays.fill(row, -1);
        
        return solve(obstacleGrid, 0, 0, dp);
    }
}