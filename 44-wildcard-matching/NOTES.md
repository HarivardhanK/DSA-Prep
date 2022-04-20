boolean ans =  ism(s,p,i-1,j-1,dp);
dp[i][j] = (ans)?1:0;
return ans;
}
else if(p.charAt(j-1)=='*'){
boolean ans =  ism(s,p,i,j-1,dp) || ism(s,p,i-1,j,dp);
dp[i][j] = (ans)?1:0;
return ans;
}
return false;
}
public boolean isMatch(String s, String p) {
int n=s.length(),m=p.length();
int dp[][] = new int[n+1][m+1];
for(int row[]:dp)
Arrays.fill(row,-1);
return ism(s,p,n,m,dp);
}
}
```
​
### Tabulation:
​
```
class Solution {
public boolean isMatch(String s, String p) {
int n=s.length(),m=p.length();
boolean dp[][] = new boolean[n+1][m+1];
dp[0][0] = true;
for(int i=1;i<=n;i++) dp[i][0] = false;
for(int j=1;j<=m;j++){
boolean flag = true;
for(int ind=j;ind>0;ind--){
if(p.charAt(ind-1)!='*'){
flag = false;
break;
}
}
dp[0][j] = flag;