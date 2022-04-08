if(dp[i]!=-1) return dp[i];
int onestep = mch(cost,i-1,dp);
int twostep = mch(cost,i-2,dp);
dp[i] = cost[i] + Math.min(onestep,twostep);
return dp[i];
}
public int minCostClimbingStairs(int[] cost) {
int []dp = new int[cost.length];
Arrays.fill(dp,-1);
return Math.min(mch(cost, cost.length-1,dp),mch(cost,cost.length-2,dp));
}
}
```
​
​
### Tabulation:
​
```
class Solution {
public int minCostClimbingStairs(int[] cost) {
int []dp = new int[cost.length];
for(int i=0;i<cost.length;i++){
if(i<2) dp[i]=cost[i];
else dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
}
return Math.min(dp[cost.length-1],dp[cost.length-2]);
}
}
```