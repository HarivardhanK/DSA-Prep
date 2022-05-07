### Recursion Solution:
​
```
class Solution {
public int mch(int[] cost, int i){
if(i<0) return 0;
if(i==0 || i==1) return cost[i];
int onestep = mch(cost,i-1);
int twostep = mch(cost,i-2);
return cost[i]+Math.min(onestep,twostep);
}
public int minCostClimbingStairs(int[] cost) {
return Math.min(mch(cost, cost.length-1),mch(cost,cost.length-2));
}
}
```
​
### Memoization:
​
```
class Solution {
public int mch(int[] cost, int i,int[] dp){
if(i<0) return 0;
if(i==0 || i==1){
dp[i] = cost[i];
return dp[i];