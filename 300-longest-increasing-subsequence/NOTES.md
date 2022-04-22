return dp[0][-1+1];
}
}
```
​
### Space optimised:
```
class Solution {
public int lengthOfLIS(int[] nums) {
int n=nums.length;
int next[] = new int[n+1];
//base case filling 0's in nth row -- by default the values are 0
//nested loops
for(int ind=n-1;ind>=0;ind--){
int curr[] = new int[n+1];
for(int prevind=ind-1;prevind>=-1;prevind--){
int len = next[prevind+1];
if(prevind==-1 || nums[prevind] < nums[ind]){
//dp[ind+1][ind] -> dp[ind+1][ind+1] don't know why
len=Math.max(1+next[ind+1],len);
}
curr[prevind+1]=len;
}
next=curr;
}
return next[-1+1];
}
}
```