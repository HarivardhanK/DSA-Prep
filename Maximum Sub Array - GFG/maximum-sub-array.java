//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        int negs = 0;
        for(int ele: a) if(ele < 0) negs++;
        ArrayList<Integer> ans = new ArrayList<>();
        if(negs == n) {
            ans.add(-1);
            return ans;
        }
        int start = -1, end = -1;
        int st = 0, curr = 0, max = 0, maxsz = 0;
        
        for(int i = 0; i < n; i++) {
            if(a[i] < 0) {
                int size = i - st;
                if(max < curr) {
                    max = curr;
                    maxsz = size;
                    start = st;
                    end = i;
                }
                else if(max == curr) {
                    if(size > maxsz || (start == -1 && end == -1)) {
                        maxsz = size;
                        start = st;
                        end = i;
                    }
                }
                st = i+1;
                curr = 0;   
            }
            else {
                curr += a[i];
            }
        }
        int size = n-1 - st;
        if(max < curr) {
            max = curr;
            maxsz = size;
            start = st;
            end = n;
        }
        else if(max == curr) {
            if(size > maxsz || (start == -1 && end == -1)) {
                maxsz = size;
                start = st;
                end = n;
            }
        }
        
        for(int i = start; i < end; i++) ans.add(a[i]);
        
        return ans;
    }
}