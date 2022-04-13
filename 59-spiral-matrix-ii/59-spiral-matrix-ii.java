class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rows=0,cols=0,rowe=n-1,cole=n-1;
        int num=1;
        while(rows<=rowe && cols<=cole){
            for(int i=cols;i<=cole;i++){
                ans[rows][i]=num;
                num++;
            }
            rows++;
            for(int i=rows;i<=rowe;i++){
                ans[i][cole]=num;
                num++;
            }
            cole--;
            for(int i=cole;i>=cols;i--){
                ans[rowe][i]=num++;
            }
            rowe--;
            for(int i=rowe;i>=rows;i--){
                ans[i][cols]=num++;
            }
            cols++;
        }
        return ans;
    }
}