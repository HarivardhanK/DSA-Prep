### Solution using DP
```
class Solution {
private int solve(int nums[], int tar) { //TC: Exponential
if(tar <= 0) return tar==0?1:0;
int ans = 0;
for(int i = 0; i < nums.length; i++) {
ans += solve(nums, tar - nums[i]);
}
return ans;
}
private int solveMemo(int nums[], int tar, int[] dp) { //TC: O(target * nums.length)
if(tar <= 0) return tar==0?1:0;
if(dp[tar] != -1) return dp[tar];
int ans = 0;
for(int i = 0; i < nums.length; i++) {
ans += solveMemo(nums, tar - nums[i], dp);
}
return dp[tar] = ans;
}
private int solveTabu(int nums[], int tar) { //TC: O(target*nums.length)
int[] dp = new int[tar+1];
dp[0] = 1;
for(int j = 1; j <= tar; j++){
for(int i = 0; i < nums.length; i++) {
if(j - nums[i] >= 0)
dp[j] += dp[j - nums[i]];
}
}
return dp[tar];
}
public int combinationSum4(int[] nums, int target) {
//         return solve(nums, target);
//         int[] dp = new int[target+1];
//         Arrays.fill(dp, -1);
//         return solveMemo(nums, target, dp);
return solveTabu(nums, target);
}
}
```