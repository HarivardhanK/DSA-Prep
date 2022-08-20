class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        
        for(int i = 0; i < n; i++) {
            for(int refil = i; refil >= 0 && dp[refil] >= stations[i][0]; refil--) {
                dp[refil + 1] = Math.max(dp[refil + 1], dp[refil] + stations[i][1]);
            }
        }
        
        for(int i = 0; i <= n; i++) {
            if(target <= dp[i]) return i;
        }
        
        return -1;
    }
}


