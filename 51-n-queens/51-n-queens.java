class Solution {
    private boolean isValid(int r, int c, char[][] mat){
        //row & col
        for(int i=0; i < mat.length; i++) {
            if(mat[r][i] == 'Q' || mat[i][c] == 'Q')
                return false;
        }
        //left diag 
        int row = r-1,col = c-1;
        while(row >= 0 && col >= 0) {
            if(mat[row][col] == 'Q')
                return false;
            row--;col--;
        }
        //right diag
        while(r >= 0 && c < mat.length) {
            if(mat[r][c] == 'Q')
                return false;
            r--;c++;
        }
        
        return true;
    }
    private void solve(char[][] mat, int r, List<List<String>> ans){
        if(r == mat.length){
            List<String> pans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat.length; j++) {
                    sb.append(mat[i][j]);
                }
                pans.add(sb.toString());
                sb.delete(0,sb.length());
            }
            
            ans.add(pans);
            return;
        }
        for(int c = 0; c < mat.length; c++) {
            if(isValid(r, c, mat)){
                mat[r][c] = 'Q';
                solve(mat, r+1, ans);
                mat[r][c] = '.';
            }
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        for(char[] row: mat){
            Arrays.fill(row,'.');
        }
        List<List<String>> ans = new ArrayList<>();
        solve(mat, 0, ans);
        return ans;
    }
}