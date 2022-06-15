// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<String>();
        boolean[][] visited = new boolean[n][n];
        
        if(m[0][0]==1 && m[m.length-1][m.length-1] == 1) 
            findPathHelper(m,0,0,visited,"",ans);
        return ans;
    }
    private static void findPathHelper(int[][] up, int row, int col, boolean [][]visited, String p, ArrayList<String> ans){
        if(row==up.length-1 && col==up.length-1){
            ans.add(p);
            return;
        }
        if(row < 0 || col < 0 || row >= up.length || col >= up.length || up[row][col]==0 || visited[row][col])
            return;
        visited[row][col]=true;
        
        //go downwards
        findPathHelper(up,row+1,col,visited,p+"D",ans);
        
        //go Left
        findPathHelper(up,row,col-1,visited,p+"L",ans);
        
        //go Right
        findPathHelper(up,row,col+1,visited,p+"R",ans);
        
        //go Upwards
        findPathHelper(up,row-1,col,visited,p+"U",ans);
        
        visited[row][col]=false;
        
    }
    
}