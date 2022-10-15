//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) 
            return -1;
            
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        vis[source[0]][source[1]] = true;
        q.offer(new int[]{source[0], source[1]});
        int[][] direc = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        int ans = -1;
        
        while(q.size() > 0) {
            int size = q.size();
            ans++;
            
            while(size-- > 0) {
                int[] node = q.poll();
                if(node[0] == destination[0] && node[1] == destination[1]) return ans;
                
                for(int[] d: direc) {
                    int nr = node[0] + d[0], nc = node[1] + d[1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]) {
                        q.offer(new int[]{nr,nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}
