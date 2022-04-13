class Solution {
    boolean cp(int[] nums,int i,int s,int[][] dp){
        if(s==0) return true;
        if(i==0) return nums[0]==s;
        if(dp[i][s]!=-1) return dp[i][s]==0?false:true;
        boolean nopick = cp(nums,i-1,s,dp);
        boolean pick = false;
        if(nums[i]<=s)
            pick = cp(nums,i-1,s-nums[i],dp);
        dp[i][s]=nopick||pick?1:0;
        return nopick||pick;
    }
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int ele:nums) sum+=ele;
        if((sum&1)!=0) return false;//if odd we can't divide into two
        int[][] dp = new int[n][(sum/2)+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        
        //if we can get one subset with sum of totalsum/2 then
        //we can partition the array into two
        return cp(nums,n-1,sum/2,dp);
    }
}