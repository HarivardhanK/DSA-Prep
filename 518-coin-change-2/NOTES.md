return c(amount, coins.length-1,coins,dp);
}
}
```
​
### Tabulation:
​
```
class Solution {
public int change(int amount, int[] coins) {
int [][]dp = new int[coins.length][amount+1];
//base condition:
for(int i=0;i<=amount;i++)
if(i%coins[0]==0) dp[0][i]=1;
else dp[0][i]=0;
//nested loops:
for(int i=1;i<coins.length;i++){
for(int tar=0;tar<=amount;tar++){
int nonpick = dp[i-1][tar];
int pick=0;
if(coins[i]<=tar)
pick=dp[i][tar-coins[i]];
dp[i][tar]=pick+nonpick;
}
}
return dp[coins.length-1][amount];
}
}
```
​
### Space optimised:
```
​
```