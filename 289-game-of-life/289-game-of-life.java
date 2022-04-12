class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length,m=board[0].length;
        int [][]nexgen = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=0;
                if(i-1>=0){
                    if(j-1>=0)
                        count+=board[i-1][j-1];
                    if(j>=0)
                        count+=board[i-1][j];
                    if(j+1<m)
                        count+=board[i-1][j+1];
                }
                if(i+1<n){
                    if(j-1>=0)
                        count+=board[i+1][j-1];
                    if(j>=0)
                        count+=board[i+1][j];
                    if(j+1<m)
                        count+=board[i+1][j+1];
                }
                if(j-1>=0)
                    count+=board[i][j-1];
                if(j+1<m)
                    count+=board[i][j+1];
                
                if(board[i][j]==1 &&count<2){
                    nexgen[i][j]=0;
                }
                else if(board[i][j]==1 && (count==2 || count==3)){
                    nexgen[i][j] = 1;
                }
                else if(board[i][j]==1 &&count>3){
                    nexgen[i][j]=0;
                }
                else if(board[i][j]==0 && count==3){
                    nexgen[i][j]=1;
                } 
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=nexgen[i][j];
            }
        }
    }
}