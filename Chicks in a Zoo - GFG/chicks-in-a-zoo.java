//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        long[] dp = new long[N];
        dp[0] = 1;
        long sum = 1;
        for(int i = 1;i < N; i++) {
            if(i >= 6) sum -= dp[i-6];
            dp[i] = sum*2;
            sum += dp[i];
        }
        return sum;
    }
}