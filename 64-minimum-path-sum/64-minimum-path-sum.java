class Solution {
    private int minpath(int[][] grid,int r, int c,int[][] dp){
        if(r<0 || c<0) return (int)1e9;
        if(r==0 && c==0) return grid[r][c];
        if(dp[r][c]!=-1) return dp[r][c];
        
        int up = minpath(grid,r-1,c,dp);
        int left = minpath(grid,r,c-1,dp);
        return dp[r][c] = grid[r][c] + Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[] : dp) Arrays.fill(row,-1);
        return minpath(grid,m-1,n-1,dp);
    }
}