//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    private void dfs(int[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j])
            return;
        vis[i][j] = true;
        grid[i][j] = 0;
        dfs(grid,vis, i+1, j);
        dfs(grid, vis, i, j+1);
        dfs(grid, vis, i-1, j);
        dfs(grid, vis, i, j-1);
        grid[i][j] = 1;
    }
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int[][] grid = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();
        
        for(int[] point: operators) {
            grid[point[0]][point[1]] = 1;
            int count = 0;
            boolean vis[][] = new boolean[rows][cols];
            for(int i =0; i< rows; i++) {
                for(int j =0; j < cols; j++) {
                    if(!vis[i][j] && grid[i][j] == 1) {
                        dfs(grid, vis, i, j);
                        count++;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
        
        // int count = 0;
        // boolean vis[][] = new boolean[rows][cols];
        // for(int i =0; i< rows; i++) {
        //     for(int j =0; j < cols; j++) {
        //         if(!vis[i][j] && grid[i][j] == 1) {
        //             dfs(grid, vis, i, j);
        //             count++;
        //         }
        //     }
        // }
        // int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        // for(int i = operators.length-1; i>=0; i--) {
        //     int r = operators[i][0], c = operators[i][1];
        //     grid[r][c] = 0;
            
        //     boolean delisland = true;
        //     for(int[] d: dir) {
        //         int nr = r+d[0], nc = c+d[1];
        //         if(nr > 0 && nc > 0 && nr < rows && nc < cols) {
        //             if(grid[nr][nc] == 1) delisland = false;
        //         }
        //     }
        //     ans.add(count);
        //     if(delisland) count--;
        // }
        // Collections.reverse(ans);
        // return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends