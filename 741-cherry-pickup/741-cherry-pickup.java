class Solution {
    private int f(int[][] grid, int r1, int c1,int r2,int dp[][][]){
        int c2 = r1+c1-r2;
        if(r1>=grid.length || r2>=grid.length || c1>=grid.length || c2>=grid.length || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        else if(r1==grid.length-1 && c1==grid.length-1) return grid[r1][c1];
        if(dp[r1][c1][r2]!=0) return dp[r1][c1][r2];
        
        int cherries = 0 ;
        if(r1==r2 && c1==c2) cherries += grid[r1][c1];
        else cherries += grid[r1][c1]+grid[r2][c2];
        
        int f1 = f(grid,r1+1,c1,r2+1,dp); //v,v
        int f2 = f(grid,r1,c1+1,r2,dp); //h,h
        int f3 = f(grid,r1+1,c1,r2,dp); //v,h
        int f4 = f(grid,r1,c1+1,r2+1,dp); //h,v
        
        cherries += Math.max(Math.max(f1,f2),Math.max(f3,f4));
        dp[r1][c1][r2] = cherries;
        return dp[r1][c1][r2];
        
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int dp[][][] = new int[n][n][n];
        return Math.max(0,f(grid,0,0,0,dp));
    }
}