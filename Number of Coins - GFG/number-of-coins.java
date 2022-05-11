// { Driver Code Starts
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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{
    private int solve(int coins[], int i, int tar,int[][] dp){
        if(tar==0) return 0;
        if(i==0){
            if(tar%coins[0]==0) return tar/coins[0];
            return (int)1e9;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        
        int nonpick = solve(coins,i-1,tar,dp);
        int pick = (int)1e9;
        if(coins[i]<=tar){
            pick = 1 + solve(coins, i, tar-coins[i],dp);
        }
        
        return dp[i][tar] = Math.min(pick,nonpick);
    }
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int dp[][] = new int[M][V+1];
	    for(int row[]:dp)
	        Arrays.fill(row,-1);
	    
	    int ans = solve(coins,coins.length-1,V,dp);
	    return ans==(int)1e9?-1:ans;
	} 
	
}