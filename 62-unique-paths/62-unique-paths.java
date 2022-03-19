class Solution {
    // public int totalpaths(int r, int c, int dp[][]){
    //     if(r==0 && c==0) return 1;
    //     if(r<0 || c<0) return 0;
    //     if(dp[r][c]==-1){ 
    //         int count=0;
    //         count+=totalpaths(r-1,c, dp);
    //         count+=totalpaths(r,c-1, dp);
    //         dp[r][c]=count;
    //     }
    //     return dp[r][c];
    // }
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        // int dp[][] = new int[m][n];
        // for(int row[]:dp) Arrays.fill(row,-1);
        // return totalpaths(m-1,n-1,dp);
        // for(int i=0;i<m;i++) dp[i][0]=1;
        // for(int i=1;i<n;i++) dp[0][i]=1;
        int prev[] = new int[n];
        Arrays.fill(prev,1);
        for(int r=1;r<m;r++){
            int curr[]=new int[n];
            for(int c=0;c<n;c++){
                //base cond
                if(c==0)
                    curr[c]=1;
                else 
                    curr[c]=prev[c]+curr[c-1];
                
            }
            prev=curr;
        }
        return prev[n-1];
    }
}