//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long ans ;
    static void solve(long x, int prev, long curr) {
        if(curr > x) return;
        if(curr <= x) {
            ans = Math.max(ans, curr);
        }
        if(prev == 0)
            solve(x, prev+1, curr*10+1);
        else if(prev == 9) 
            solve(x, prev-1, curr*10+8);
        else {
            solve(x, prev+1, curr*10+prev+1);
            solve(x, prev-1, curr*10+prev-1);
        }
    }
    static long jumpingNums(long x) {
        int digs = (int)(Math.log(x)/Math.log(10))+1;
        ans = Long.MIN_VALUE;
        for(int i = 0; i <= 9; i++) {
            solve(x, i, i);
        }
        return ans;
    }
}