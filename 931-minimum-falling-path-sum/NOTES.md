```
​
​
### Memoization:
​
```
class Solution {
int minpathsum(int [][]mat , int r, int c, int[][] dp){
if(c<0|| c>=mat[0].length) return Integer.MAX_VALUE;
if(r==mat.length-1) return mat[r][c];
if(dp[r][c]==-1){
int left,down,right;
left=minpathsum(mat, r+1, c-1,dp);//left
down=minpathsum(mat,r+1,c,dp);//down
right=minpathsum(mat,r+1,c+1,dp);//right
dp[r][c]=mat[r][c]+Math.min(left,Math.min(down, right));
}
return dp[r][c];
}
public int minFallingPathSum(int[][] matrix) {
int min=Integer.MAX_VALUE;
int dp[][] = new int[matrix.length][matrix[0].length];
for(int row[]:dp) Arrays.fill(row,-1);
for(int mat=0;mat<matrix[0].length;mat++)
min=Math.min(min,minpathsum(matrix,0,mat,dp));
return min;
}
}
```