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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private void genPaths(int n, int i, List<Integer> ul, List<Integer> pl, ArrayList<ArrayList<Integer>> ans) {
        if(i == 0) {
            ArrayList<Integer> t = new ArrayList<>(pl);
            for(int num = 0; num < n; num++) t.add(1);
            ans.add(t);
            return;
        }
        if(n == 0) {
            ans.add(new ArrayList<>(pl));
            return;
        }
        if(n < 0) return;
        
        pl.add(ul.get(i));
        genPaths(n-ul.get(i), i, ul, pl, ans);
        pl.remove(pl.size()-1);
        
        genPaths(n, i-1, ul, pl, ans);
    }
    
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        List<Integer> list = new ArrayList<>();
        for(int num = 1; num <= n; num++) list.add(num);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        genPaths(n, list.size()-1, list, new ArrayList<>(), ans);
        return ans;
    }
}