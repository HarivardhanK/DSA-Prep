Approach1 : time and space complexity is same for two approaches
==> complexities:
TC: (N * N) SC : O(1)
```
class Solution {
public void rotate(int[][] matrix) {
//by rotating the four cells
int n=matrix.length;
for(int i=0;i<(n+1)/2;i++){
for(int j=0;j<n/2;j++){
int temp = matrix[n-1-j][i];
matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
matrix[j][n-1-i]=matrix[i][j];
matrix[i][j]=temp;
}
}
}
}
```
Approach 2
​
```
class Solution {
public void rotate(int[][] matrix) {
//first transpose and then reverse the each in the matrix
for(int i=0;i<matrix.length;i++){
for(int j=0;j<i+1;j++){
int temp=matrix[i][j];
matrix[i][j]=matrix[j][i];
matrix[j][i]=temp;
}
}
//then reversing the each row
int n=matrix.length;
for(int i=0;i<n;i++){
for(int j=0;j<n/2;j++){
int temp=matrix[i][j];
matrix[i][j]=matrix[i][n-1-j];
matrix[i][n-1-j]=temp;
}
}
}
}
```