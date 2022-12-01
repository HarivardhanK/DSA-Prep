//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        int l = 0, r = n-1;
        long mod = 100000001;
        for(int i = 0; i < n; i++) {
            if((i&1) == 0) {
                long newAns = (arr[r]%mod);
                arr[i] = newAns*mod+arr[i];
                r--;
            }
            else {
                long newAns = (arr[l]%mod);
                arr[i] = newAns*mod+arr[i];
                l++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            arr[i] = arr[i]/mod;
        }
        
    }
    
}
// 6 5 4 1 2 3
// 6 5 2 1 4 3
// 6 1 5 2 4 3

