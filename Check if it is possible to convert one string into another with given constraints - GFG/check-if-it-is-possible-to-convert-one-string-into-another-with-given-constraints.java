//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isItPossible(String s, String t, int m, int n) {
        // 1. check for the size of both the strings
        if(m != n) return 0;
        
        // 2. check for the frequency of a's and b's
        int cnt_a = 0, cnt_b = 0;
        for(int i = 0; i < m; i++) {
            if(s.charAt(i) == 'A') cnt_a++;
            else if(s.charAt(i) == 'B') cnt_b++;
            
            if(t.charAt(i) == 'A') cnt_a--;
            else if(t.charAt(i) == 'B') cnt_b--;
        }
        
        if(cnt_a != 0 || cnt_b != 0) return 0;
        
        int i = 0, j = 0;
        while(i < n && j < m) {
            while(i < n && s.charAt(i) == '#') i++;
            while(j < m && t.charAt(j) == '#') j++;
            if(i == n || j == m) break;
            
            if(s.charAt(i) == 'A') {
                if(t.charAt(j) == 'B' || j > i) return 0;
                j++;i++;
            }
            else {
                if(t.charAt(j) == 'A' || i > j) return 0;
                j++; i++;
            }
        }
        
        return 1;
    }
};