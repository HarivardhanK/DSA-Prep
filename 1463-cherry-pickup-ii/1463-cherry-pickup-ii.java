class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int prev[][] = new int[m][m];
        for(int row = n-1;row>=0;row--){
            int curr[][] = new int[m][m];
            for(int col1=0;col1<m;col1++){
                for(int col2=0;col2<m;col2++){
                    int res = 0;
                    res+=grid[row][col1];
                    if(col1!=col2) res+=grid[row][col2];
                    if(row!=n-1){
                        int max=0;
                        for(int c1=col1-1;c1<=col1+1;c1++){
                            for(int c2=col2-1;c2<=col2+1;c2++){
                                if(c1>=0 && c2>=0 && c1<m && c2<m){
                                    max=Math.max(max,prev[c1][c2]);
                                }
                            }
                        }
                        res+=max;
                    }
                    curr[col1][col2] = res;
                }
            }
            prev=curr;
        }
        return prev[0][m-1];
    }
}