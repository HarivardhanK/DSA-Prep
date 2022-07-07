class Solution {
    private boolean solve(String s, String t, String st, int i, int j, int k, int[][][] dp) {
        
        if(i == s.length() && j==t.length() && k==st.length()) return true;
        if(k == st.length()) return false;
        
        if(i < s.length() && j < t.length() && dp[i][j][k] != -1) 
            return (dp[i][j][k] == 0)?false:true;
        
        boolean ans = false;
        if((i < s.length() && s.charAt(i) == st.charAt(k)) && (j < t.length() && t.charAt(j) == st.charAt(k))) {
            ans = solve(s,t,st,i+1,j,k+1,dp) || solve(s,t,st,i,j+1,k+1,dp);
        }
        else if(i < s.length() && s.charAt(i) == st.charAt(k)) {
            ans = solve(s,t,st,i+1,j, k+1,dp);
        }
        else if(j < t.length() && t.charAt(j) == st.charAt(k)){
            ans = solve(s,t,st,i,j+1,k+1,dp);
        }
        if(i < s.length() && j < t.length())
            dp[i][j][k] = (ans)?1:0;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
        for(int row[][] : dp) 
            for(int r[]: row)
                Arrays.fill(r, -1);
        
        return solve(s1, s2, s3, 0, 0, 0, dp);
    }
}