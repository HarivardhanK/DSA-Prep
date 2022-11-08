//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    private int getcheckbit(int n) {
        int cnt = 0;
        while(n > 0) {
            if((n&1) == 1) return cnt;
            cnt++;
            n>>=1;
        }
        return cnt;
    }
    public int[] twoOddNum(int arr[], int n)
    {
        int xor = 0;
        for(int ele: arr) {
            xor ^= ele;
        }
        
        int set = xor, notset =xor;
        int rightsetbit = getcheckbit(xor);
        for(int ele: arr) {
            if(((ele>>rightsetbit)&1 )== 0) notset ^= ele;
            else set ^= ele;
        }
        return new int[]{Math.max(set, notset), Math.min(set, notset)};
    }
}