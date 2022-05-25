### Time Limit exceeded  - TC = O(n^2)
```
class Solution {
public int maxEnvelopes(int[][] envelopes) {
int n = envelopes.length;
if(n==0) return 0;
//sort according to the width and heigth in increasing order
Arrays.sort(envelopes, (a, b)-> a[0]==b[0]?a[1] - b[1]:a[0]-b[0]);
int lis[] = new int[n];
Arrays.fill(lis,1);
int max = 1;
for(int ind = 0 ;ind<n;ind++){
for(int j=0;j<ind;j++){
if(envelopes[ind][0] > envelopes[j][0] &&
envelopes[ind][1] > envelopes[j][1]  &&
lis[ind] < 1 + lis[j]){
lis[ind] = 1 + lis[j];
max = Math.max(max, lis[ind]);
}
}
}
return max;
}
}
```
​
### Using binary Search - TC = O(NlogN)
​
```
​
```