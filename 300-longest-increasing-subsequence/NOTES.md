for(int row[]:dp) Arrays.fill(row,-1);
return lis(nums,0,-1,dp);
}
}
```
​
### Tabulation:
​
```
class Solution {
public int lengthOfLIS(int[] nums) {
int n=nums.length;
int dp[][] = new int[n+1][n+1];
//base case filling 0's in nth row -- by default the values are 0
//nested loops
for(int ind=n-1;ind>=0;ind--){
for(int prevind=ind-1;prevind>=-1;prevind--){
int len = dp[ind+1][prevind+1];
if(prevind==-1 || nums[prevind] < nums[ind]){
//dp[ind+1][ind] -> dp[ind+1][ind+1] don't know why
len=Math.max(1+dp[ind+1][ind+1],len);
}
dp[ind][prevind+1]=len;
}
}
return dp[0][-1+1];
}
}
```