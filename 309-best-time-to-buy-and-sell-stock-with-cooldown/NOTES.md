### Memoization: [TLE]
```
class Solution {
private int mp(int[] prices,int ind,int buy, int[][] dp){
if(ind==prices.length) return 0;
if(buy==1){
return Math.max(-prices[ind]+mp(prices,ind+1,0,dp),mp(prices,ind+1,1,dp));
}
else if(buy==2){
return mp(prices,ind+1,1,dp);
}
else{
return Math.max(prices[ind]+mp(prices,ind+1,2,dp),mp(prices,ind+1,0,dp));
}
}
public int maxProfit(int[] prices) {
//sell-0, buy-1 , cooldown - 2
int n=prices.length;
int [][]dp = new int[n][3];
return mp(prices,0,1,dp);
}
}
```
​
### Tabulation:
```
​
```