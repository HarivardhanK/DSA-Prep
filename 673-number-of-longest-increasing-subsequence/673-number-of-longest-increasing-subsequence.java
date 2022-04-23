class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j];
                    //inherit
                    cnt[i] = cnt[j];
                }
                else if(nums[j]<nums[i] && dp[i]==1+dp[j]){
                    //increase
                    cnt[i]+=cnt[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) 
                count+=cnt[i];
        }
        return count;
    }
}