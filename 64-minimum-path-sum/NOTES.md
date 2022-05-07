## Memoization
​
```
class Solution {
int minPath(int[][] grid, int r, int c, int[][] dp){
if(r==grid.length-1 && c==grid[0].length-1) return grid[r][c];
if(r>grid.length-1 || c>grid[0].length-1) return Integer.MAX_VALUE;
if(dp[r][c]==-1){
dp[r][c] = grid[r][c]+Math.min(minPath(grid, r+1, c, dp),minPath(grid, r, c+1, dp));
}
return dp[r][c];
}
public int minPathSum(int[][] grid) {
int dp[][] = new int[grid.length][grid[0].length];
for(int row[]:dp) Arrays.fill(row,-1);
return minPath(grid, 0, 0,dp);
}
}
```
​
​
### Tabluation:
​
```
class Solution {
public int minPathSum(int[][] grid) {
int dp[][] = new int[grid.length][grid[0].length];
for(int r=0;r<grid.length;r++){
for(int c=0;c<grid[0].length;c++){
if(r==0 && c==0){
dp[r][c]=grid[r][c];
continue;
}
if(r==0){
dp[r][c]=grid[r][c]+dp[r][c-1];
continue;
}
if(c==0){
dp[r][c]=grid[r][c]+dp[r-1][c];
continue;
}
dp[r][c]=grid[r][c]+Math.min(dp[r-1][c],dp[r][c-1]);
}
}
return dp[grid.length-1][grid[0].length-1];
}
}
```
​
### Space optimisation:
​
```
class Solution {
public int minPathSum(int[][] grid) {
//space optimised
int prev[]= new int[grid[0].length];
for(int r=0;r<grid.length;r++){