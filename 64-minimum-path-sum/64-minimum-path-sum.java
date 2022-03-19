class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        // for(int row[]:dp) Arrays.fill(row,-1);
        // return minPath(grid, 0, 0,dp);
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(r==0 && c==0){
                    dp[r][c]=grid[r][c];
                    continue;
                }
                if(r==0){
                    dp[r][c]=grid[r][c]+dp[r][c-1];
                    continue;
                }
                if(c==0){
                    dp[r][c]=grid[r][c]+dp[r-1][c];
                    continue;
                }
                dp[r][c]=grid[r][c]+Math.min(dp[r-1][c],dp[r][c-1]);
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }
}