class Solution {
    private int solve(int i, int j, int m, int n, int[][] dp) {
        if(i == m - 1 && j == n - 1) return 1;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = solve(i + 1, j, m, n, dp) + solve(i, j + 1, m, n, dp);
    }
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
//         for(int row[]: dp) 
//             Arrays.fill(row, -1);
        
//         return solve(0, 0, m, n, dp);
        // dp[0][0] = 1;
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(i > 0) 
        //             dp[i][j] = dp[i - 1][j];
        //         if(j > 0)
        //             dp[i][j] +=  dp[i][j - 1];
        //     }
        // }
        // return dp[m - 1][n - 1];
        
        int[] prev = new int[n];
        for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            curr[0] = 1;
            for(int j = 0; j < n; j++) {
                if(i > 0) 
                    curr[j] = prev[j];
                if(j > 0)
                    curr[j] += curr[j - 1];
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}