// { Driver Code Starts
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
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        if(m == 1 || n == 1) return m;
        
        long lo = 1, hi = m;
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long pow = (int)Math.pow(mid, n);
            // System.out.println(pow);
            if(pow == m) return (int)mid;
            else if(pow < m) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}