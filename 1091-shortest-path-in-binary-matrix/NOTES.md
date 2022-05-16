### Recursion && Back tracking
```
class Solution {
private int solve(int[][] grid, int r, int c){
if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==1){
return (int)1e9;
}
if(r==grid.length-1 && c==grid[0].length-1) return 1;
grid[r][c] = 1;
int shortdis = (int)1e9;
//up
shortdis = Math.min(shortdis, solve(grid,r-1,c));
//down
shortdis = Math.min(shortdis, solve(grid,r+1,c));
//right
shortdis = Math.min(shortdis, solve(grid,r,c+1));
//left
shortdis = Math.min(shortdis, solve(grid,r,c-1));
//up-left
shortdis = Math.min(shortdis, solve(grid,r-1,c-1));
//down-left
shortdis = Math.min(shortdis, solve(grid,r+1,c-1));
//up-right
shortdis = Math.min(shortdis, solve(grid,r-1,c+1));
//down-right
shortdis = Math.min(shortdis, solve(grid,r+1,c+1));