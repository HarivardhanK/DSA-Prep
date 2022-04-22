### Memoization:
​
```
class Solution {
private int lis(int nums[],int ind,int prevind,int dp[][]){
if(ind<0){
return 0;
}
if(dp[ind][prevind+1]!=-1) return dp[ind][prevind+1];
if(prevind==-1 || nums[prevind]>nums[ind]){
return dp[ind][prevind+1]=Math.max(1+lis(nums,ind-1,ind,dp),lis(nums,ind-1,prevind,dp));
}
else{
return dp[ind][prevind+1]=lis(nums,ind-1,prevind,dp);
}
}
public int lengthOfLIS(int[] nums) {
int n=nums.length;
int dp[][] = new int[n][n+1];
for(int row[]:dp) Arrays.fill(row,-1);
return lis(nums,n-1,-1,dp);
}
}
```