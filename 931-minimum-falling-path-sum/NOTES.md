### Naive recursion
​
```
class Solution {
int minpathsum(int [][]mat , int r, int c){
if(c<0|| c>=mat[0].length) return Integer.MAX_VALUE;
if(r==mat.length-1) return mat[r][c];
int left,down,right;
left=minpathsum(mat, r+1, c-1);//left
down=minpathsum(mat,r+1,c);//down
right=minpathsum(mat,r+1,c+1);//right
return mat[r][c]+Math.min(left,Math.min(down, right));
}
public int minFallingPathSum(int[][] matrix) {
int min=Integer.MAX_VALUE;
for(int mat=0;mat<matrix[0].length;mat++)
min=Math.min(min,minpathsum(matrix,0,mat));
return min;
}
}
```