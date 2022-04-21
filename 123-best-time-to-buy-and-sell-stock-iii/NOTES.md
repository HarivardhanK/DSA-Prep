```
class Solution {
private int mp(int[] prices,int ind,int noOfTrans,int dp[][] ){
if(noOfTrans>4 || ind==prices.length) return 0;
if(dp[ind][noOfTrans]!=-1) return dp[ind][noOfTrans];
int profit=0;
if(noOfTrans%2==0){
profit=Math.max(-prices[ind]+mp(prices,ind+1,noOfTrans+1,dp),
mp(prices,ind+1,noOfTrans,dp));
}
else{
profit=Math.max(prices[ind]+mp(prices,ind+1,noOfTrans+1,dp),
mp(prices,ind+1,noOfTrans,dp));
}
return dp[ind][noOfTrans]=profit;
}
public int maxProfit(int[] prices) {
int n=prices.length;
int dp[][] = new int[n][5];
for(int r[]:dp)
Arrays.fill(r,-1);
return mp(prices,0,0,dp);
}
}
```