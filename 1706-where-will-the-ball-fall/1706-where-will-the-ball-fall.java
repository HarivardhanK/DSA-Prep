class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] ans = new int[m];
        
        for(int j = 0; j < m; j++) {
            int col = j, i=0;
            for(; i < n; i++) {
                if(col < 0 || col >= m) break;
                
                if(grid[i][col] == 1 && col+1 < m && grid[i][col+1] == 1) {
                    col++;
                } 
                else if(grid[i][col] == -1 && col-1 >= 0 && grid[i][col-1] == -1) {
                    col--;
                }
                else{
                    break;
                }
            }
            if(i < n) ans[j] = -1;
            else ans[j] = col;
        }
        return ans;
    }
}