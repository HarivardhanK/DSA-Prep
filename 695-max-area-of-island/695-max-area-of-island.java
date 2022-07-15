class Solution {
    private int floodfill(int[][] grid, int i, int j) {
        if(i < 0 || j <0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return 0;
        }
        
        int count = 1;
        grid[i][j] = 0;
        count += floodfill(grid, i + 1, j);
        count += floodfill(grid, i, j + 1);
        count += floodfill(grid, i-1, j);
        count += floodfill(grid, i, j - 1);
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++ ) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int count = floodfill(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}