### Memoization:
​
```
class Solution {
private int lis(int nums[],int ind,int prevind,int dp[][]){
if(ind==nums.length){
return 0;
}
if(dp[ind][prevind+1]!=-1) return dp[ind][prevind+1];
int len = lis(nums,ind+1,prevind,dp);
if(prevind==-1 || nums[prevind]<nums[ind]){
return dp[ind][prevind+1]=Math.max(1+lis(nums,ind+1,ind,dp),len);
}
else{
return dp[ind][prevind+1]=len;
}
}
public int lengthOfLIS(int[] nums) {
int n=nums.length;
int dp[][] = new int[n][n];
for(int row[]:dp) Arrays.fill(row,-1);
return lis(nums,0,-1,dp);
}
}
```
​
### Tabulation:
​
```
​
```