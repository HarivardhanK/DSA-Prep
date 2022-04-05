class Solution {
    public int minFallingPathSum(int[][] grid) {
        int prev[] = new int[grid.length];
        prev=grid[0];
        for(int i=1;i<grid.length;i++){
            int curr[] = new int[grid.length];
            for(int j=0;j<grid.length;j++){
                int min=Integer.MAX_VALUE;
                for(int k=0;k<prev.length;k++){
                    if(k!=j) min=Math.min(min,prev[k]);
                }
                curr[j]=grid[i][j]+min;
            }
            prev=curr;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prev.length;i++){
            min=Math.min(min,prev[i]);
        }
        return min;
    }
}