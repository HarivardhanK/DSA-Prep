### memoization:
​
```
class Solution {
private int lps(String s, int st, int en,int[][] dp){
if(st>en) return 0;
if(st==en) return 1;
if(dp[st][en]!=-1) return dp[st][en];
if(s.charAt(st)==s.charAt(en)){
return dp[st][en] = 2 + lps(s,st+1,en-1,dp);
}
else{
return dp[st][en] = Math.max(lps(s,st+1,en,dp),lps(s,st,en-1,dp));
}
}
public int longestPalindromeSubseq(String s) {
int dp[][] = new int[s.length()][s.length()];
for(int row[]:dp) Arrays.fill(row,-1);
return lps(s,0,s.length()-1,dp);
}
}
```
​
### Tabulation:
```
class Solution {
public int longestPalindromeSubseq(String s) {
int n=s.length();
int dp[][] = new int[n][n];
for(int i=n-1;i>=0;i--){
dp[i][i]=1;
for(int j=i+1;j<n;j++){
if(s.charAt(i)==s.charAt(j)){
dp[i][j] = 2 + dp[i+1][j-1];
}
else{
dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
}
}
}
return dp[0][n-1];
}
}
```