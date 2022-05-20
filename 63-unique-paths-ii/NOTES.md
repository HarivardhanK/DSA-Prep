### Memoization
​
```
class Solution {
private int solve(int[][] grid, int r, int c, int dp[][]){
if(r<0 || c<0 || grid[r][c]==1) return 0;
if(r==0 && c==0) return 1;
if(dp[r][c]!=-1) return dp[r][c];
int count = solve(grid, r-1, c,dp);
count += solve(grid, r, c-1,dp);
return dp[r][c] = count;
}
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
int m = obstacleGrid.length, n = obstacleGrid[0].length;
int dp[][] = new int[m+1][n+1];
for(int row[]:dp)
Arrays.fill(row, -1);
return solve(obstacleGrid, m-1, n-1, dp);
​
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