}
}
```
​
### Tabulation:
​
```
class Solution {
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
if(obstacleGrid.length==1 && obstacleGrid[0].length ==1) return obstacleGrid[0][0]^1;
if(obstacleGrid[0][0]==1) return 0;
//space optimised
int m=obstacleGrid.length;
int n=obstacleGrid[0].length;
int prev[]=new int[n];
for(int r=0;r<m;r++){
int curr[] = new int[n];
for(int c=0;c<n;c++){
if(obstacleGrid[r][c]==1){
curr[c]=0;
continue;
}
if(r==0 && c==0){
curr[c]=1;
continue;
}
curr[c]=0;
if(r>0)
curr[c]+=prev[c];
if(c>0)
curr[c]+=curr[c-1];
}
prev=curr;
}
return prev[n-1];
}
}
```