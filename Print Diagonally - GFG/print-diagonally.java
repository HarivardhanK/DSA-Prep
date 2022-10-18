//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        ArrayList<Integer> ans =  new ArrayList<>();
        for(int col = 0; col < N; col++) {
            int r = 0, c = col;
            while(r >= 0 && r < N && c >= 0 && c < N) {
                ans.add(A[r++][c--]);
            }
        }
        for(int row = 1; row < N; row++) {
            int r = row, c = N-1;
            while(r >= 0 && r < N && c >= 0 && c < N) {
                ans.add(A[r++][c--]);
            }
        }
        return ans;
    }
}
