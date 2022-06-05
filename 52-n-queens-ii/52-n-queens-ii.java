class Solution {
    private boolean isvalid(char[][] board, int r, int c) {
        //row and col
        for(int i = 0;i < board.length; i++){
            if(board[r][i] == 'Q' || board[i][c] == 'Q') 
                return false;
        }
        
        //left diag
        int row = r, col = c;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q')
                return false;
            row--; col--;
        }
        
        //right diag
        while(r >= 0 && c < board.length) {
            if(board[r][c] == 'Q')
                return false;
            r--; c++;
        }
        
        return true;
    }
    
    private int solve(char[][] board, int r) {
        if(r == board.length) {
            return 1;
        }
        int count  = 0;
        for(int c = 0; c < board.length; c++) {
            if(isvalid(board, r, c)){
                board[r][c] = 'Q';
                count += solve(board, r+1);
                board[r][c] = '.';
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char r[]: board) {
            Arrays.fill(r, '.');
        }
        return solve(board, 0);
    }
}