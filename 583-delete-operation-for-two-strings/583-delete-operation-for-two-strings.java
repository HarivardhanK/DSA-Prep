class Solution {
    private int lcs(String word1, String word2, int ind1, int ind2, int[][] dp) {
        if(ind1 == word1.length() || ind2 == word2.length())
            return 0;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        if(word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcs(word1, word2, ind1 + 1, ind2 + 1, dp);
        }
        int first = lcs(word1, word2, ind1 + 1, ind2, dp);
        int second = lcs(word1, word2, ind1, ind2 + 1, dp);
        return dp[ind1][ind2] = Math.max(first, second);
    }
    public int minDistance(String word1, String word2) {
        //longest common subsequence - lcs
        //we need to find the lcs of these two stings
        //w1 = sea and w2 = eat then lcs = 2
        // answer =  sum of the length of two words - 2 * lcs(w1, w2)
        
        int dp[][] = new int[word1.length()][word2.length()];
        for(int row[]: dp) 
            Arrays.fill(row, -1);
        
        return (word1.length() + word2.length()) - (2 * lcs(word1, word2, 0, 0, dp));
        
    }
}