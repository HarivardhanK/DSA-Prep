//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        int r = 0, g = 0, b = 0;
        for(String str: a) {
            if(str.equals("R")) r++;
            else if(str.equals("G")) g++;
            else b++;
        }
        if(r == n || b == n || g == n) return n;
        if((r%2==0 && b%2==0 && g%2==0) || (r%2!=0 && b%2 != 0 && g%2 != 0)) 
            return 2;
        return 1;
    }
}