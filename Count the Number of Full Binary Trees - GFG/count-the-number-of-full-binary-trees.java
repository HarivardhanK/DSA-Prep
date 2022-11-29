//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numoffbt(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int numoffbt(int arr[], int n)
    {
        int min = Integer.MAX_VALUE, max = 1;
        for(int ele: arr) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }
        
        int[] dp = new int[max+1];
        for(int ele: arr) {
            dp[ele]=1;
        }
        
        int ans = 0, MOD = (int)1e9+7;
        for(int i = min;i <= max; i++) {
            if(dp[i] == 0) continue;
            
            for(int j = i+i; j <= max && (j/i) <= i; j+=i) {
                if(dp[j] != 0) {
                    dp[j] += (dp[i]*dp[j/i])%MOD;
                    if((j/i) != i) {
                        dp[j] += (dp[i]*dp[j/i])%MOD;
                    }
                }
            }
            ans = (ans+dp[i])%MOD;
        }
        return ans;
    }
}