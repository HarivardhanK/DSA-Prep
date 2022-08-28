class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int r, c, ind;
        //1. first visit all the cells of the 0th row as the 
        // starting element of the diagonal
        for(int j = 0; j < m; j++) {
            List<Integer> diag = new ArrayList<>();
            r = 0; c = j;
            
            while(r < n && c < m) {
                diag.add(mat[r][c]);
                r++;c++;
            }
            
            //sort the diagonal put it back into the mat
            Collections.sort(diag);
            ind = 0;r = 0; c = j;
            while(r < n && c < m && ind < diag.size()) {
                mat[r][c] = diag.get(ind++);
                r++;c++;
            }
        }
        // now visit all the cells of the 0th column as the starting element
        // of the diagonals
        for(int i = 1; i < n;i++) {
            List<Integer> diag = new ArrayList<>();
            r = i; c = 0;
            while(r < n && c < m) {
                diag.add(mat[r][c]);
                r++;c++;
            }
            Collections.sort(diag);
            ind = 0;r = i; c = 0;
            while(r < n && c < m && ind < diag.size()) {
                mat[r][c] = diag.get(ind++);
                r++;c++;
            }
        }
        return mat;
    }
}