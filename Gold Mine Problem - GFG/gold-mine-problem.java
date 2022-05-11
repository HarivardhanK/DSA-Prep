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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

// class Solution{
//     static int maxGold(int n, int m, int mat[][])
//     {
//         // code here
//         for(int j=1;j<m;j++){
//             for(int i=0;i<n;i++){
//                 int max = 0;
//                 System.out.println("i"+i+" j"+j);
//                 if(i>0) max = Math.max(max, mat[i-1][j-1]);
//                 max = Math.max(max, mat[i][j-1]);
//                 if(i<n-2) max = Math.max(max, mat[i+1][j-1]);
//                 mat[i][j] += max;
//             }
//         }
//         int max = 0;
//         for(int i=0;i<n;i++) max = Math.max(max, mat[i][m-1]);
//         return max;
//     }
// }
class Solution
{
    static boolean isValid(int n, int m, int i, int j)
    {
        if(i>=n || j>=m || i<0 || j<0) return false;
        
        return true;
    }
    static int maxGold(int n, int m, int M[][])
    {
        int gmax = 0; //Global maximum
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int max_ele = 0;
                
                if(isValid(n, m, j-1, i-1))
                {
                    max_ele = Math.max(max_ele, M[j-1][i-1]);
                }
                if(isValid(n, m, j, i-1))
                {
                    max_ele = Math.max(max_ele, M[j][i-1]);
                }
                if(isValid(n, m, j+1, i-1))
                {
                    max_ele = Math.max(max_ele, M[j+1][i-1]);
                }
                
                M[j][i] += max_ele;
                
                if(gmax<M[j][i]) gmax = M[j][i];
                
            }
            
        }
        
        return gmax;
    }
}