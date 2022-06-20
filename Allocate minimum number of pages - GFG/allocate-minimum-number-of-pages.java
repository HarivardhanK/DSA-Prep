// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    private static boolean isPossible(int[] arr, int m, int mid) {
        int studCount = 1, pageCount = 0;
        for(int i = 0; i<arr.length; i++) {
            if(pageCount + arr[i] <= mid) {
                pageCount += arr[i];
            }
            else{
                studCount++;
                if(studCount > m || arr[i] > mid) return false;
                pageCount = arr[i];
            }
        }
        return true;
    }
    public static int findPages(int[] arr,int N,int m) {
        int sum = 0;
        for(int ele: arr) 
            sum += ele;
        
        int low = 0, high = sum;
        int ans = -1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(arr, m, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}