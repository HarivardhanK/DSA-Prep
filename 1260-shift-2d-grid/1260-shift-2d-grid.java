class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        k%=(n*m);
        if(k==(n*m)) k=0;
        while(k-->0){
            int last=0;
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    if(i==n-1 && j==m-1){
                        last = grid[i][j];
                        continue;
                    }
                    else{
                        if(j+1<m)
                            grid[i][j+1] = grid[i][j];
                        else
                            grid[i+1][0] = grid[i][j];
                    }
                }
            }
            grid[0][0] = last;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            for(int j=0;j<m;j++){
                ans.get(i).add(grid[i][j]);
            }
        }
        return ans;
    }
}