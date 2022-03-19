class Solution {
    public int paths(int r, int c, boolean grid[][] , int obsgrid[][], int dp[][]){
        if(r<0 && c<0) return 0;
        if(grid[r][c] || obsgrid[r][c]==1) return 0;
        if(r==0 && c==0) return 1;
        if(dp[r][c]==0){
            grid[r][c]=true;
            int count=0;
            if(r-1>=0)
                count+=paths(r-1,c,grid,obsgrid,dp);
            if(c-1>=0)
                count+=paths(r,c-1,grid,obsgrid,dp);
            grid[r][c]=false;
            dp[r][c]=count;
        }
        return dp[r][c];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==1 && obstacleGrid[0].length ==1) return obstacleGrid[0][0]^1;
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int row[]:dp)
            Arrays.fill(row,0);
        boolean grid[][] = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        paths(obstacleGrid.length-1,obstacleGrid[0].length-1,grid,obstacleGrid,dp);
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}