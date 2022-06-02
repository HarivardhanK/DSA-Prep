class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] transMat = new int[n][m];
        
        for(int i = 0;i < n; i++) {
            for(int j = 0; j < m; j++) {
                transMat[i][j] = matrix[j][i];
            }
        }
        
        return transMat;
    }
}