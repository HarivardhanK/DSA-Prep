class Solution {
    private void dfs(List<Integer>[] adj, int ind, boolean[] vis) {
        vis[ind] = true;
        for(int it: adj[ind]) {
            if(!vis[it])
                dfs(adj, it, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] adj = new ArrayList[n];
        
        //build graph
        for(int i = 0;i < n; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj[i].add(j);
                }
            }
        }
        
        
        boolean vis[] = new boolean[n];
        int number_of_provinces = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                number_of_provinces++;
                dfs(adj, i, vis);
            }
        }
        return number_of_provinces;
    }
}