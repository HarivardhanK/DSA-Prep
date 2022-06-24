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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

/*
    1 2 4 6 6 3 78
    
    1 3 7 13 13 6 78
    1 2 3  4  4 3 1 
*/

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	   // int[] ans = new int[n];
	    int[] sum = new int[n];
	    for(int i = 0; i < n; i++) 
	        sum[i] = arr[i];
	    
	   // Arrays.fill(ans, 1);
	    
	    for(int i = 1; i < n; i++ ) {
	       // int prevMin = 0;
	        int prevsum = 0;
	        for(int j = 0; j < i; j++) {
	            if(arr[j] < arr[i]){
	                if(prevsum < sum[j])
    	               // prevMin = ans[j];
    	                prevsum = sum[j];
	            }
	            
	        }
	       // ans[i] += prevMin;
	        sum[i] += prevsum;
	    }
	    
	   // System.out.println(Arrays.toString(sum));
	    int max = 1;
	    for(int ele: sum) 
	        max = Math.max(ele, max);
	    return max;
	}  
}