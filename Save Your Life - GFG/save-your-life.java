//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(x[i], b[i]);
        
        int start = 0, s = 0, e = 0, currcnt = 0, maxcnt = Integer.MIN_VALUE;
        for(int i =0; i< w.length(); i++) {
            currcnt += (map.containsKey(w.charAt(i)))?map.get(w.charAt(i)):w.charAt(i);
            if(currcnt > maxcnt) {
                maxcnt = currcnt;
                s = start;
                e = i;
            }
            if(currcnt < 0) {
                currcnt = 0;
                start = i+1;
            }
        }
        if(maxcnt != Integer.MIN_VALUE) return w.substring(s, e+1);
        return "";
    }
    
    // 1 + 2 
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends