// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsvis[]){
        vis[node] = true;
        dfsvis[node] = true;
        
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                if(dfs(it,adj,vis,dfsvis))
                    return true;
            }
            else if(dfsvis[it])
                return true;
        }
        dfsvis[node] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean dfsvis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i])
                if(dfs(i,adj,vis,dfsvis)) return true;
        }
        return false;
    }
    public boolean isCyclicbfs(int V, ArrayList<ArrayList<Integer>> adj) {
        //kahns algorithm
        int indegree[] = new int[V];
        for(ArrayList<Integer> node: adj){
            for(Integer it:node){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        //enqueue the nodes whose indegree is equal to 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            cnt++;
            
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(cnt==V) return false;
        return true;
    }
}