class Solution {
    public int minPathSum(int[][] grid) {
        //space optimised
        int prev[]= new int[grid[0].length];
        for(int r=0;r<grid.length;r++){
            int curr[]= new int[grid[0].length];
            for(int c=0;c<grid[0].length;c++){
                if(r==0 && c==0){
                    curr[c]=grid[r][c];
                    continue;
                }
                if(r==0){
                    curr[c]=grid[r][c]+curr[c-1];
                    continue;
                }
                if(c==0){
                    curr[c]=grid[r][c]+prev[c];
                    continue;
                }
                curr[c]=grid[r][c]+Math.min(curr[c-1],prev[c]);
            }
            prev=curr;
        }
        
        return prev[grid[0].length-1];
    }
}