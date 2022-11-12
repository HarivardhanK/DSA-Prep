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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int find(int[] freq, int k) {
        int same = 0, diff = 0;
        for(int ele: freq) {
            if(ele > same) {
                diff += same;
                same = ele;
            }
            else {
                diff += ele;
            }
        }
        return (diff <= k) ? same+diff: -1;
    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ans = 0, i = 0;
        for(int j = 0;j < s.length(); j++) {
            freq[s.charAt(j)-'A']++;
            int curr = find(freq, k);
            if(curr == -1) {
                freq[s.charAt(i++)-'A']--;
            }
            else {
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}