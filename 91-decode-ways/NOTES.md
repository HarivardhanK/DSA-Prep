}
}
```
​
### Tabulation:
​
```
class Solution {
public int numDecodings(String s) {
int dp[] = new int[s.length()+1];
//base conditions
dp[s.length()] = 1;
for(int i=s.length()-1;i>=0;i--){
int count = 0;
count += (s.charAt(i)!='0')?dp[i+1]:0;
if(i<s.length()-1){
int num = Integer.parseInt(s.substring(i,i+2));
count += !(num>9 && num<27)?0:dp[i+2];
}
dp[i] = count;
}
return dp[0];
}
}
```
​
### Space optimisation:
```
​
```