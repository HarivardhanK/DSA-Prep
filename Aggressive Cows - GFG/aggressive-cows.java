//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private static boolean isvalid(int[] stalls, int k, int dist) {
        int curr = stalls[0], cnt = 1;
        for(int i = 1; i < stalls.length; i++) {
            if(stalls[i] - curr >= dist) {
                cnt++;
                curr = stalls[i];
            }
        }
        return cnt >= k;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int lo = 0, hi = stalls[n-1], ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(isvalid(stalls, k, mid)) {
                ans = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return ans;
    }
}