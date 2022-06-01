// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int M[][] = new int[N][N];
            String arr[] = in.readLine().trim().split("\\s+");
            for(int i = 0;i < N*N; i++)
                M[i/N][i%N] = Integer.parseInt(arr[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.distinct(M, N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int distinct(int M[][], int N)
    {
        Set<Integer> ans = new HashSet<>();
        for(int j = 0; j < M.length; j++)
            ans.add(M[0][j]);
        
        for(int i = 1; i < M.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j< M.length; j++){
                if(ans.contains(M[i][j]))
                    set.add(M[i][j]);
            }
            ans = set;
        }
        return ans.size();
    }
}