class Solution {
    private int solve(int[] nums, int[] m, int s, int mind, int[][] dp) {
        if(mind == m.length) return 0;
        if(dp[s][mind] != Integer.MIN_VALUE) return dp[s][mind];
        
        // we don't need to pass the end index in the recerrence because we can calculate it by
        // using the start index of the nums , mind is the number of elements has been picked
        int e = nums.length-(mind-s)-1;
        
        int left = solve(nums, m, s+1, mind+1, dp) + (m[mind]*nums[s]);
        int right = solve(nums, m, s, mind+1, dp) + (m[mind]*nums[e]);
        return dp[s][mind] = Math.max(left, right);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int[][] dp = new int[m][m];
        for(int[] row: dp) 
            Arrays.fill(row, Integer.MIN_VALUE);
        
        return solve(nums, multipliers, 0, 0, dp);
    }
}