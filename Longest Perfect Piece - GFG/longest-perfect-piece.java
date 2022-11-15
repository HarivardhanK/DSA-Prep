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
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        int ans = 0;
        for(int i = 0, j = 0; j < N; j++) {
            min.add(arr[j]);
            max.add(arr[j]);
            
            if(max.peek() - min.peek() <= 1) 
                ans = Math.max(ans, j-i+1);
            
            while(i < j && max.peek()-min.peek() > 1) {
                max.remove(arr[i]);
                min.remove(arr[i]);
                i++;
            }
        }
        
        return ans;
        
    }
};