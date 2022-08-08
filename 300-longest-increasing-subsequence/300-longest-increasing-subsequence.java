class Solution {
    private int solve(int[] nums, int i, int prev) {
        if(i == nums.length) return 0;
        
        if(prev == -1 || nums[prev] < nums[i]) {
            return Math.max(1+solve(nums, i+1, i), solve(nums,i+1, prev));
        }
        return solve(nums, i+1, prev);
    }
    // here there are two changing parameters so it is 2d matrix
    private int solveMem(int[] nums, int i, int prev, int[][] dp) {
        if(i >= nums.length) return 0;
        
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        
        if(prev == -1 || nums[prev] < nums[i]) {
            return dp[i][prev+1] = Math.max(1+solveMem(nums, i+1, i,dp), solveMem(nums,i+1, prev,dp));
        }
        return dp[i][prev+1] = solveMem(nums, i+1, prev,dp);
    }
    private int solveTab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        //base case is to fill 0's in the nth row
        
        for(int i = n - 1; i >= 0; i--) {
            for(int prev = n - 1; prev >= -1; prev--) {
                int len = dp[i+1][prev+1];
                if(prev == -1 || nums[prev] < nums[i]) 
                    len = Math.max(1+dp[i+1][i+1], len);
                
                dp[i][prev+1] = len;
            }
        }
        return dp[0][0];
        
        
    }
    public int lengthOfLIS(int[] nums) {
        // return solve(nums, 0, -1);
        
        
        // here we took the value of prev as -1 in array there 
        // is no -1 so increment prev's value and also i value
//         int n = nums.length;
//         int[][] dp = new int[n][n];
//         for(int[] row: dp) Arrays.fill(row, -1);
        
//         return solveMem(nums, 0, -1, dp);
        
        return solveTab(nums);
    }
}