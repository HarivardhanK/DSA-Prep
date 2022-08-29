### Related problems:
Surrounded Regions
Walls and Gates
Number of Islands II
Number of Connected Components in an Undirected Graph
Number of Distinct Islands
Max Area of Island
Count Sub Islands
Find All Groups of Farmland
​
```
class Solution {
private void dfsFloodFill(char[][] grid, int i,int j){
if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]=='0')
return;
grid[i][j] = '0';
dfsFloodFill(grid,i-1,j);
dfsFloodFill(grid,i+1,j);
dfsFloodFill(grid,i,j-1);
dfsFloodFill(grid,i,j+1);
}
public int numIslands(char[][] grid) {
int m = grid.length;
int n = grid[0].length;
int countOfIslands = 0;
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
if(grid[i][j]=='1'){
dfsFloodFill(grid,i,j);
countOfIslands++;
}
}
}
return countOfIslands;
}
}
```