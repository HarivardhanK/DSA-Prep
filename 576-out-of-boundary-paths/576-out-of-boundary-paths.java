class Solution {
    int M = 1000000007;
    private int solve(int m, int n, int maxMove, int i, int j, int[][][] dp) {
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        if(maxMove == 0) return 0;
        if(dp[i][j][maxMove] >= 0) return dp[i][j][maxMove];
        
        return dp[i][j][maxMove] = (((solve(m, n, maxMove - 1, i - 1, j, dp) + solve(m, n, maxMove - 1, i, j - 1, dp))%M + 
                solve(m, n, maxMove - 1, i + 1, j, dp))%M + solve(m, n, maxMove - 1, i, j + 1, dp))%M;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        
        for(int row[][]: dp)
            for(int r[]: row) 
                Arrays.fill(r, -1);
        
        return solve(m, n, maxMove, startRow, startColumn, dp);
    }
}