class Solution {
    public int f(int[][] grid, int r,int c1, int c2,int dp[][][]){
        if(r>=grid.length || c1<0 || c2<0||( c1>=grid[0].length || c2>=grid[0].length) ){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c1][c2]!=0) return dp[r][c1][c2];
        int cherries = 0;
        if(c1==c2) cherries+=grid[r][c1];
        else cherries+=grid[r][c1] + grid[r][c2];
        
        if(r==grid.length-1){
            return cherries;
        }
        int f1 = f(grid,r+1,c1-1,c2-1,dp);
        int f2 = f(grid,r+1,c1-1,c2,dp);
        int f3 = f(grid,r+1,c1-1,c2+1,dp);
        int f4 = f(grid,r+1,c1,c2-1,dp);
        int f5 = f(grid,r+1,c1,c2,dp);
        int f6 = f(grid,r+1,c1,c2+1,dp);
        int f7 = f(grid,r+1,c1+1,c2-1,dp);
        int f8 = f(grid,r+1,c1+1,c2,dp);
        int f9 = f(grid,r+1,c1+1,c2+1,dp);
        f9 = Math.max(f9,Math.max(Math.max(Math.max(f1,f2),Math.max(f3,f4)),Math.max(Math.max(f5,f6),Math.max(f7,f8))));
        cherries += f9;
        dp[r][c1][c2]=cherries;
        return cherries;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int dp[][][] = new int[n][m][m];
        return f(grid,0,0,grid[0].length-1,dp);
    }
}