public int climbstairsHelper(int n,int[] dp){
if(n<0) return 0;
if(n==0 || n==1){
dp[n]=1;
return dp[n];
}
if(dp[n-1]==-1 && dp[n-2]==-1)
dp[n]= climbstairsHelper(n-1,dp)+climbstairsHelper(n-2,dp);
else
dp[n]=dp[n-1]+dp[n-2];
return dp[n];
}
public int climbStairs(int n){
int[] dp = new int[n+1];
Arrays.fill(dp, -1);
return climbstairsHelper(n,dp);
}
}
```
​
### step3:
## tabulation :
filling the array in iterative fashion
Time Complexity: O(N)
Space Complexity: O(N)
​
Reason: We are using an array of size N+1 ~O(N)
​
```
class Solution {
public int climbStairs(int n) {
if(n==1) return 1;
int dp[] = new int[n+1];
dp[0]=1;
dp[1]=1;
for(int i=2;i<n+1;i++){
dp[i]=dp[i-1]+dp[i-2];
}
return dp[n];
}
}
```