class Solution {
    private int maxrob(int[] nums,int i,int dp[]){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int nonpick = maxrob(nums,i-1,dp);
        int pick = nums[i]+maxrob(nums,i-2,dp);
        return dp[i] = Math.max(pick,nonpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return maxrob(nums,n-1,dp);
    }
}