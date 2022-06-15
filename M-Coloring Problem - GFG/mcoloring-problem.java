// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    private boolean isSafe(int node, List<Integer>[] adj, int[] colors, int color) {
        for(int nodes: adj[node]) {
            if(colors[nodes] == color) 
                return false;
        }
        return true;
    }
    private boolean solve(int node, List<Integer>[] adj, int maxColors, int n, int colors[]) {
        if(node == n)
            return true;
        for(int c = 1; c <= maxColors; c++) {
            if(isSafe(node, adj, colors, c)){
                colors[node] = c;
                if(solve(node + 1, adj, maxColors, n, colors))
                    return true;
                colors[node] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
                if(graph[i][j] == true) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        
        return solve(0, adj, m, n, new int[n]);
    }
}