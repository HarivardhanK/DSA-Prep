### Memoization:
```
class Solution {
private int c(int[] coins,int tar,int i,int [][]dp){
if(tar==0) return 0;
if(i==0){
if(tar%coins[i]==0) return tar/coins[i];
return (int)1e9;
}
if(dp[i][tar]!=-1) return dp[i][tar];
int nopick =c(coins,tar,i-1,dp);
int pick = Integer.MAX_VALUE;
if(tar>=coins[i])
pick=1+c(coins,tar-coins[i],i,dp);
return dp[i][tar]=Math.min(pick,nopick);
}
public int coinChange(int[] coins, int amount) {
int dp[][] = new int[coins.length][amount+1];
for(int row[] : dp) Arrays.fill(row,-1);
int mincoins= c(coins,amount,coins.length-1,dp);
return mincoins==1e9?-1:mincoins;
}
}
```
### Tabulation:
```
​
```