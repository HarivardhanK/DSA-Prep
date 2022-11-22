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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countTriplets(nums);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countTriplets(int[] nums){
        int cnt = 0, n = nums.length;
        for(int j = 0;j < n-1; j++) {
            int min_eles = 0, max_eles = 0;
            for(int i = 0; i < j; i++) {
                if(nums[i] < nums[j]) min_eles++;
            }
            for(int k = j+1; k < n; k++) {
                if(nums[j] < nums[k]) max_eles++;
            }
            
            cnt += min_eles*max_eles;
        }
        return cnt;
    }
}
// 1 2 5 7 3 4 => 6+2 = 8