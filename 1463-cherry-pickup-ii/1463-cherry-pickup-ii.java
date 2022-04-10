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
        int max=0;
        for(int col1=c1-1;col1<=c1+1;col1++){
            for(int col2=c2-1;col2<=c2+1;col2++){
                max=Math.max(max,f(grid,r+1,col1,col2,dp));
            }
        }
        dp[r][c1][c2]=cherries+max;
        return cherries+max;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int dp[][][] = new int[n][m][m];
        return f(grid,0,0,grid[0].length-1,dp);
    }
}