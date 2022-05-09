class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean vis[] = new boolean[n];
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    vis[node] = true;
                    for(int it:adjlist.get(node)){
                        if(!vis[it])
                            q.offer(it);
                    }
                }
                if(vis[source] && vis[destination]) return true;
                else if(vis[source] || vis[destination]){
                    return false;
                }
            }
        }
        return false;
    }
}