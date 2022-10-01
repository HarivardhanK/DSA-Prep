class Solution {
    private int numdec(String s, int i, int[] dp) {
        if(i >= s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        int count = 0;
        if(s.charAt(i) >= '1' && s.charAt(i) <= '9') 
            count = numdec(s, i+1, dp);
        if(i+1 < s.length() && s.charAt(i) != '0') {
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num >= 10 && num <= 26) 
                count += numdec(s, i+2, dp);
        }
        return dp[i] = count;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return numdec(s, 0, dp);
    }
}