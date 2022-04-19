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