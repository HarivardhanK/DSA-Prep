### Memoization:
​
```
class Solution {
private int md(String s, String t, int i, int j, int dp[][]){
if(i==0) return j;
if(j==0) return i;
if(dp[i][j]!=-1) return dp[i][j];
if(s.charAt(i-1)==t.charAt(j-1))
return dp[i][j] = md(s,t,i-1,j-1,dp);
// insert, delete and replace
return dp[i][j] = 1+Math.min(md(s,t,i,j-1,dp),Math.min(md(s,t,i-1,j,dp),md(s,t,i-1,j-1,dp)));
}
public int minDistance(String s, String t) {
int n=s.length(),m=t.length();
int dp[][] = new int[n+1][m+1];
for(int row[]:dp) Arrays.fill(row,-1);
return md(s,t,n,m,dp);
}
}
```
​
### Tabulation:
​
```
class Solution {
public int minDistance(String s, String t) {
int n=s.length(),m=t.length();
int dp[][] = new int[n+1][m+1];
for(int i=0;i<=n;i++) dp[i][0] = i;
for(int j=1;j<=m;j++) dp[0][j] = j;
for(int i=1;i<=n;i++){
for(int j=1;j<=m;j++){
if(s.charAt(i-1)==t.charAt(j-1)){
dp[i][j] = dp[i-1][j-1];
}
else{
dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
}
}
}
return dp[n][m];
}
}
```