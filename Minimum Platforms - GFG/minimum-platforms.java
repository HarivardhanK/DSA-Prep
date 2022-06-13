// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // sort two arrays differently without combining together
        // the starting and leaving time stamps differ ignore that
        // as wanted to count the minimum platforms required
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // take two variables platformNeeded and maximumPlatformNeeded
        int plat_needed = 0, max = 0;
        // keep indexes of the two array differently and traverse throught the array
        int i = 0, j =0;
        while(i < n && j < n) {
            // now if the starting time is less than dept time increment plat_needed by 1
            // and update maximum
            // increment index of start arr
            if(arr[i] <= dep[j]) {
                plat_needed++;
                max = Math.max(max, plat_needed);
                i++;
            }
            // else decrement the platformNeeded and increment index of dept arr
            else{

                plat_needed--;
                j++;
            }
        }
        // return maximumPlatformNeeded
        return max;
    }
    
}

