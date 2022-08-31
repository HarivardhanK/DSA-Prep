class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int prevHeight) {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if(heights[i][j] < prevHeight || ocean[i][j]) return;
        
        ocean[i][j] = true;
        
        for(int[] d: dir) {
            dfs(heights, ocean, i + d[0], j + d[1], heights[i][j]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            
            dfs(heights, atlantic, n - 1, j, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            
            dfs(heights, atlantic, i, m - 1, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}