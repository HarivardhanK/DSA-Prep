class Solution {
    private int solve(List<List<Integer>> triangle, int row, int col, int dp[][]) {
        if(row > triangle.size() - 1 || col > triangle.get(row).size() - 1) 
            return Integer.MAX_VALUE;  
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        
        int min = Math.min(solve(triangle, row + 1, col, dp), solve(triangle, row + 1, col + 1, dp));
        return dp[row][col] = triangle.get(row).get(col) + min;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];
        
        for(int i = 0; i < triangle.size(); i++)
            dp[i] = new int[triangle.get(i).size()];
        
        for(int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        int ans =  solve(triangle, 0, 0, dp);
        return ans;
    }
}

