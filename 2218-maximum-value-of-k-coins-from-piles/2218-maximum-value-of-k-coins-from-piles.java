class Solution {
    private int f(List<List<Integer>> piles, int k, int i, int[][] dp){
        if(k<=0 || i==piles.size()) return 0;
        if(dp[i][k]==-1){
            int max = f(piles,k,i+1,dp);
            int sum=0;
            for(int j=0;j<Math.min(piles.get(i).size(),k);j++){
                sum+=piles.get(i).get(j);
                max = Math.max(max, sum + f(piles,k-(j+1),i+1,dp));
            }
            dp[i][k]=max;
        }
        return dp[i][k];
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()][k+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(piles,k,0,dp);
    }
}