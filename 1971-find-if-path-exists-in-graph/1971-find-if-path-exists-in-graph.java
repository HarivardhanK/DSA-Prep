class Solution {
    private boolean dfs(boolean[] vis, int s, int e, List<List<Integer>> adjlist){
        vis[s] = true;
        for(int node:adjlist.get(s)){
            if(node == e) return true;
            if(!vis[node]){
                if(dfs(vis,node,e,adjlist)) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean vis[] = new boolean[n];
        List<List<Integer>> adjlist = new ArrayList<>();
        // start -- building graph
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
        }
        // end - graph has built
        
        if(dfs(vis,source,destination,adjlist)) return true;
        if(vis[source] && vis[destination]) return true;
        else if(vis[source] || vis[destination]){
            return false;
        }
        return false;
    }
}