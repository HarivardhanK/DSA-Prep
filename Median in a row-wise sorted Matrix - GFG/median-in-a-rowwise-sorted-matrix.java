// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int countNumberLessThanEqualToMid(int[] row, int mid) {
        int l = 0, h = row.length - 1;
        while(l <= h) {
            int md = l + (h - l)/2;
            if(row[md] <= mid) l = md + 1;
            else h = md - 1;
        }
        return l; 
    }
    int median(int matrix[][], int r, int c) {
        //here the low is the minimum possible value and
        //high is the maximum possible value - taken from the constraints of the prob
        int low = 1, high = 2000;    
        int mult = r * c;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < r; i++)
                count += countNumberLessThanEqualToMid(matrix[i], mid);
            
            if(count <= mult/2) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }
}