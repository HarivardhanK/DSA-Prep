class Solution {
    //TBD space optimisation
    public int minFallingPathSum(int[][] matrix) {
        // int dp[][] = new int[matrix.length][matrix[0].length];
        int prev[] = new int[matrix[0].length];
        prev=matrix[0];
        
        for(int r=1;r<matrix.length;r++){
            int curr[] = new int[matrix[0].length];
            for(int c=0;c<matrix[0].length;c++){
                int left = Integer.MAX_VALUE,down = left, right = left;
                if(c>0)
                    left=prev[c-1];
                down=prev[c];
                if(c<matrix[0].length-1)
                    right=prev[c+1];
                curr[c] = matrix[r][c] + Math.min(left,Math.min(down,right));
            }
            prev=curr;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++)
            min=Math.min(min,prev[i]);
        return min;
        
    }
}