class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        for(int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                sum += mat[i][j];
                mat[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int row = row1; row <= row2; row++) {
            if(col1 - 1 >= 0){
                res += mat[row][col2] - mat[row][col1-1];
            }
            else{
                res +=mat[row][col2];
            }
        }
            return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */