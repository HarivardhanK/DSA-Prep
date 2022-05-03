class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length, n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(i-1<0 || grid[i-1][j]==0) ans++;
                    if(j-1<0 || grid[i][j-1]==0) ans++;
                    if(i+1==m || grid[i+1][j]==0) ans++;
                    if(j+1==n || grid[i][j+1]==0) ans++;
                }
            }
        }
        return ans;
    }
}