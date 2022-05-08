class Solution {
    private boolean isparen(char[][] grid, int count, int r, int c,int dp[][][]){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return false;
        if(r==grid.length-1 && c==grid[0].length-1){
            if(count==1 && grid[r][c]==')'){
                return true;
            }
            return false;
        }
        if(dp[r][c][count]!=-1) return dp[r][c][count]==0?false:true;
        boolean down=false,right=false;
        if(grid[r][c]==')'){
            if(count<=0) return false;
            else{
                down = isparen(grid,count-1,r+1,c,dp);
                dp[r][c][count] = down?1:0;
                if(down) return down;
                right = isparen(grid,count-1,r,c+1,dp);
            }
        }
        else if(grid[r][c]=='('){
            down = isparen(grid,count+1,r+1,c,dp);
            dp[r][c][count] = down?1:0;
            if(down) return down;
            right = isparen(grid,count+1,r,c+1,dp);
        }
        if(down || right){
            dp[r][c][count] = 1;
        }
        else{
            dp[r][c][count] = 0;
        }
        return down || right;
    }
    public boolean hasValidPath(char[][] grid) {
        // Stack<Character> stk = new Stack<>();
        if(grid[0][0]!='(' || grid[grid.length-1][grid[0].length-1]!=')') return false;
        // boolean isval = isparen(grid,stk,0,0);
        int dp[][][] = new int[grid.length][grid[0].length][205];
        for(int row[][]:dp)
            for(int r[]:row)
                Arrays.fill(r,-1);
        return isparen(grid,0,0,0,dp);
        // return isval;
    }
}