//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min;
    private void solve(int[] arr, int s1, int s2, int idx) {
        if(idx == arr.length) {
            min = Math.min(Math.abs(s1-s2), min);
            return;
        }
        
        solve(arr, s1+arr[idx], s2, idx+1);
        solve(arr, s1, s2+arr[idx], idx+1);
    }
    private int solve(int[] arr, int s1, int s2, int idx, int[][] dp) {
        if(idx == arr.length) {
            return Math.abs(s1-s2);
        }
        if(dp[idx][s1] != -1) return dp[idx][s1];
        if(dp[idx][s2] != -1) return dp[idx][s2];
        
        return dp[idx][s1] = Math.min(solve(arr, s1+arr[idx], s2, idx+1, dp),
        solve(arr, s1, s2+arr[idx], idx+1, dp));
    }
	public int minDifference(int arr[], int n) 
	{
	   int tsum = 0;
	   for(int ele: arr) tsum += ele;
	   int[][] dp = new int[n][tsum];
	   for(int[] row: dp) {
	       Arrays.fill(row, -1);
	   }
	   return solve(arr, 0, 0, 0, dp);
	} 
}
