class Solution {
    private int lcs(String text1, String text2, int ind1, int ind2,int dp[][]){
        if(ind1==0 || ind2==0) return 0;
        
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(text1.charAt(ind1-1)==text2.charAt(ind2-1))
            return dp[ind1][ind2]=1+lcs(text1,text2,ind1-1,ind2-1,dp);
        return dp[ind1][ind2]=Math.max(lcs(text1,text2,ind1-1,ind2,dp),lcs(text1,text2,ind1,ind2-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(),n2=text2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return lcs(text1,text2,n1,n2,dp);
    }
}