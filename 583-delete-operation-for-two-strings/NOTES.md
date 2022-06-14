### Approach using the longest common subsequence:
```
class Solution {
private int lcs(String word1,String word2){
int n1=word1.length(),n2=word2.length();
int prev[] = new int[n2+1];
Arrays.fill(prev,0);
for(int i=1;i<=n1;i++){
int curr[] = new int[n2+1];
for(int j=1;j<=n2;j++){
if(word1.charAt(i-1)==word2.charAt(j-1)){
curr[j]=1+prev[j-1];
}
else{
curr[j]=Math.max(prev[j],curr[j-1]);
}
}
prev=curr;
}
return prev[n2];
}
public int minDistance(String word1, String word2) {
return ((word1.length()+word2.length())-2*(lcs(word1,word2)));
}
}
```