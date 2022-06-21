// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long merge(long[] arr, int l, int mid, int r) {
        long inv_count = 0;
        long[] temp = new long[r - l + 1];
        int i = l, j = mid, k = 0;
        while(i < mid && j <= r) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                inv_count += (mid - i); 
            }
        }
        while(i < mid) {
            temp[k++] = arr[i++];
        }
        
        while(j<=r)
            temp[k++] = arr[j++];
            
        for(i = l; i<=r; i++) {
            arr[i] = temp[i - l];
        }
        return inv_count;
    }
    static long mergesort(long[] arr, int l, int r) {
        long inv_count = 0;
        if(l < r) {
            int mid = (l + r) / 2;
            inv_count += mergesort(arr, l, mid);
            inv_count += mergesort(arr, mid + 1, r);
            
            inv_count += merge(arr, l, mid + 1, r);
        }
        return inv_count;
    }
    static long inversionCount(long arr[], long N) {
        return mergesort(arr, 0, (int)N - 1);
    }
}