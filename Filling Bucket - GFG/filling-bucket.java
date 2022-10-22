//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = (int)1e8;
    private static int solve(int n) {
        if(n <= 1) return 1;
        return solve(n-1) + solve(n-2);
    }
    private static long solve(int n, int[] dp) {
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (int)(solve(n-1, dp) + solve(n-2,dp))%mod;
    }
    static int fillingBucket(int N) {
        int[] dp = new int[N+1];
        // return solve(N);
        Arrays.fill(dp, -1);
        return (int)(solve(N, dp));
    }
};