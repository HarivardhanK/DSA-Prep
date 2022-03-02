class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int ans[] = new int[mat.length*mat[0].length];
        int r=0,c=0;
        int ansind=0;
        boolean up=true;
        while(ansind<ans.length && r<mat.length && c<mat[0].length){
            if(up){
                while(r>0 && c<mat[0].length-1) ans[ansind++] = mat[r--][c++];
                ans[ansind++] = mat[r][c];
                if(c==mat[0].length-1) r++;
                else c++;
            }
            else{
                while(c>0 && r<mat.length-1) ans[ansind++] = mat[r++][c--];
                ans[ansind++] = mat[r][c];
                if(r==mat.length-1) c++;
                else r++;
            }
            up=!up;
        }
        return ans;
    }
}