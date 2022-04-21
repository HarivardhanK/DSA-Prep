return mp(prices,0,1,dp);
}
}
```
​
### Tabulation:
```
class Solution {
public int maxProfit(int[] prices) {
//sell-0, buy-1 , cooldown - 2
int n=prices.length;
int [][]dp = new int[n+1][2];
for(int ind=n-1;ind>=0;ind--){
for(int j=0;j<=1;j++){
if(j==1){
dp[ind][j]=Math.max(-prices[ind]+dp[ind+1][0],dp[ind+1][1]);
}
else{
int smallprofit=0;
if(ind+2<n) smallprofit+=dp[ind+2][1];
dp[ind][j]= Math.max(prices[ind]+smallprofit,dp[ind+1][0]);
}
}
}
return dp[0][1];
}
}
```