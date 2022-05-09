class Solution {
    private int dfsFloodFill(int[][] grid, int i,int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]==0) 
            return 0;
        
        grid[i][j] = 0;
        int count = 1;
        
        count += dfsFloodFill(grid,i-1,j); //up
        count += dfsFloodFill(grid,i+1,j); //down
        count += dfsFloodFill(grid,i,j-1); //right
        count += dfsFloodFill(grid,i,j+1); //left
        
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea,dfsFloodFill(grid,i,j));
                }
            }
        }
        return maxArea;
    }
}