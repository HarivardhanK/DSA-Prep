class Solution {
    private int solve(String[] strs, int ind, int m, int n, int[][][] dp){
        if(ind==strs.length) return 0;
        if(m==0 && n==0) return 0;
        
        if(dp[ind][m][n]!=-1) return dp[ind][m][n];
        
        int nonpick = solve(strs, ind+1, m, n, dp);
        int pick = (int)-1e9, zero=0, ones=0;
        for(int i=0;i<strs[ind].length();i++){
            if(strs[ind].charAt(i)=='1') ones++;
            else zero++;
        }
        if(ones<=n && zero<=m){
            pick = 1 + solve(strs, ind+1, m-zero, n-ones, dp);
        }
        
        return dp[ind][m][n] = Math.max(nonpick, pick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int dp[][][] = new int[len][m+1][n+1];
        for(int rows[][] : dp)
            for(int row[] : rows)
                Arrays.fill(row,-1);
        
        return solve(strs, 0, m, n, dp);
    }
}