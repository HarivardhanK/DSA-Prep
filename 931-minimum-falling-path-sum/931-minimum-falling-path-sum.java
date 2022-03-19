class Solution {
    // int minpathsum(int [][]mat , int r, int c, int[][] dp){
    //     if(c<0|| c>=mat[0].length) return Integer.MAX_VALUE;
    //     if(r==mat.length-1) return mat[r][c];
    //     if(dp[r][c]==-1){
    //         int left,down,right;
    //         left=minpathsum(mat, r+1, c-1,dp);//left
    //         down=minpathsum(mat,r+1,c,dp);//down
    //         right=minpathsum(mat,r+1,c+1,dp);//right
    //         dp[r][c]=mat[r][c]+Math.min(left,Math.min(down, right));
    //     }
    //     return dp[r][c];
    // }
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int c=0;c<matrix[0].length;c++) dp[0][c]=matrix[0][c];
        
        for(int r=1;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                int left = Integer.MAX_VALUE,down = left, right = left;
                if(c>0)
                    left=dp[r-1][c-1];
                down=dp[r-1][c];
                if(c<matrix[0].length-1)
                    right=dp[r-1][c+1];
                dp[r][c]=matrix[r][c]+Math.min(left,Math.min(down,right));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++)
            min=Math.min(min,dp[matrix.length-1][i]);
        return min;
    }
}