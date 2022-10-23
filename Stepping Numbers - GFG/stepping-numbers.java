//{ Driver Code Starts
//Initial Template for Java


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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int ans;
    int steppingNumbers(int n, int m){
        ans = 0;
        if(n == 0) ans++;
        
        // using dfs
        // for(int i = 1; i <= 9; i++) {
        //     dfs(i, n, m);
        // }
        // return ans;
        
        // usiing bfs
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= 9; i++) q.offer(i);
        
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                int num = q.poll();
                if(num >= n && num <= m) ans++;
                
                int lastdigit = num%10;
                if(lastdigit == 9) 
                        q.offer(num*10+8);
                else if(lastdigit == 0) 
                        q.offer(num*10+1);
                else {
                    if(num*10+lastdigit+1 <= m)
                        q.offer(num*10+lastdigit+1);
                    if(num*10+lastdigit-1 <= m)
                        q.offer(num*10+lastdigit-1);
                }
            }
        }
        return ans;
    }
    
    void dfs(int num, int n, int m) {
        if(num > m) return;
        if(num >= n && num <= m) ans++;
        int lastdigit = num%10;
        if(lastdigit == 9) dfs(num*10+8, n, m);
        else if(lastdigit == 0) dfs(num*10+1,n , m);
        else {
            dfs(num*10+lastdigit+1, n, m);
            dfs(num*10+lastdigit-1, n, m);
        }
    }
}
