int[][] dp = new int[n][(sum/2)+1];
for(int row[]:dp) Arrays.fill(row,-1);
//if we can get one subset with sum of totalsum/2 then
//we can partition the array into two
return cp(nums,n-1,sum/2,dp);
}
}
```
​
### Tabulation:
​
```
class Solution {
public boolean canPartition(int[] nums) {
int sum=0,n=nums.length;
for(int ele:nums) sum+=ele;
if((sum&1)==1) return false;//if odd we can't divide into two
boolean[][] dp = new boolean[n][(sum/2)+1];
//if we can get one subset with sum of totalsum/2 then
//we can partition the array into two
//if(s==0) fill true
int s=sum/2;
for(int i=0;i<n;i++) dp[i][0] = true;
if(nums[0]<=s) dp[0][nums[0]]=true;
for(int i=1;i<n;i++){
for(int j=1;j<=s;j++){
boolean nopick=dp[i-1][j];
boolean pick=false;
if(nums[i]<=j)
pick=dp[i-1][j-nums[i]];
dp[i][j]=nopick||pick;
}
}
return dp[n-1][s];
}
}
```
​
### Space optimised:
​