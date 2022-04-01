// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


//User function Template for Java
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0,max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k)
                max=Math.max(i+1,max);
            else if(map.containsKey(sum-k))
                max=Math.max(i-map.get(sum-k),max);
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return max;
        //only for the positive number
        // int i=0,j=0,sum=0,lenofsubarr=0;
        // while(j<arr.length){
        //     if(sum+arr[j]<k){
        //         sum+=arr[j];
        //         j++;
        //     }
        //     else{
        //         if(sum+arr[j]==k||sum==k)
        //             lenofsubarr=Math.max(lenofsubarr,j-i+1);
        //         sum=sum-arr[i]+arr[j];
        //         System.out.println(lenofsubarr+" "+i+" "+j);
        //         i++;j++;
        //     }
        // }
        // return lenofsubarr;
    }
}


