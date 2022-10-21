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
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
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
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a) {
        List<Integer> ans = new ArrayList<>();
        
        int rs = 0, cs = 0, re = R-1, ce = C-1;
        int r, c;
        
        while(rs <= re && cs <= ce) {
            c = cs;
            while(c <= ce) {
                ans.add(a[rs][c++]);
            }
            rs++;
            
            r = rs;
            while(r <= re) {
                ans.add(a[r++][ce]);
            }
            ce--;
            
            c = ce;
            while(c >= cs && re >= rs) {
                ans.add(a[re][c--]);
            }
            re--;
            
            r = re;
            while(r >= rs && cs <= ce) {
                ans.add(a[r--][cs]);
            }
            cs++;
            
        }
        Collections.reverse(ans);
        int[] anarr = new int[ans.size()];
        int idx = 0;
        for(int ele: ans) anarr[idx++] = ele;
        return anarr;
    }
}