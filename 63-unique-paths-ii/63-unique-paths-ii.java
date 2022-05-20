class Solution {
    private int solve(int[][] grid, int r, int c, int dp[][]){
        if(r<0 || c<0 || grid[r][c]==1) return 0;
        if(r==0 && c==0) return 1;
        
        if(dp[r][c]!=-1) return dp[r][c];
        
        int count = solve(grid, r-1, c,dp);
        count += solve(grid, r, c-1,dp);
        return dp[r][c] = count;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // if(m==1 && n==1) return obstacleGrid[m-1][n-1]^1;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        
        int dp[][] = new int[m][n];
        // for(int row[]:dp) 
        //     Arrays.fill(row, -1);
        // return solve(obstacleGrid, m-1, n-1, dp);
        // dp[0][0] = 1;
        for(int r=0;r<m;r++){
            for(int c = 0;c<n;c++){
                if(r==0 && c==0){
                    dp[r][c] =1;
                    continue;
                }
                if(obstacleGrid[r][c]!=0) continue;
                
                if(r>0)
                    dp[r][c] = dp[r-1][c];
                if(c>0)
                    dp[r][c] +=  dp[r][c-1];
            }
        }
        return dp[m-1][n-1];
    }
}