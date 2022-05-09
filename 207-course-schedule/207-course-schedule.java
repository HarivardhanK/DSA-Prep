class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //variant of the detect cycle in the directed graph
        List<List<Integer>> adjlist = new ArrayList<>();
        //start of graph building
        for(int i=0;i<numCourses;i++) adjlist.add(new ArrayList<>());
        for(int node[]:prerequisites){
            //first second index course after first index course
            //for node [a,b] b -> a
            adjlist.get(node[1]).add(node[0]);
        }
        // end of building the graph 
        
        boolean vis[] = new boolean[numCourses];
        boolean dfsvis[] = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(adjlist,i,vis,dfsvis))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adjlist, int i, boolean[] vis, boolean[] dfsvis){
        vis[i] = true;
        dfsvis[i] = true;
        for(int it:adjlist.get(i)){
            if(!vis[it]){
                if(dfs(adjlist,it,vis,dfsvis))
                    return true;
            }
            else if(dfsvis[it]) return true;
        }
        dfsvis[i] = false;
        return false;
    }
}