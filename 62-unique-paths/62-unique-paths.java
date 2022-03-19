class Solution {
    public int totalpaths(int r, int c, boolean grid[][], int dp[][]){
        if(r==0 && c==0) return 1;
        if(r<0 || c<0) return 0;
        if(grid[r][c]) return 0;
        if(dp[r][c]==-1){ 
            int count=0;           
            grid[r][c]=true;
            if(r-1>=0){
                count+=totalpaths(r-1,c,grid, dp);
            }
            if(c-1>=0){
                count+=totalpaths(r,c-1,grid, dp);
            }
            grid[r][c]=false;
            dp[r][c]=count;
        }
        return dp[r][c];
    }
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        boolean grid[][] = new boolean[m][n];
        int dp[][] = new int[m][n];
        for(int row[]:dp) Arrays.fill(row,-1);
        totalpaths(m-1,n-1,grid,dp);
        return dp[m-1][n-1];
    }
}