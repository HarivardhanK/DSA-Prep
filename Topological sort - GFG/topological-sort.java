// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[],Stack<Integer> stk ){
        vis[node] = true;
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis,stk);
            }
        }
        stk.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSortdfs(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> stk = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,stk);
            }
        }
        int ans[] = new int[V];
        int ind=0;
        while(!stk.isEmpty()){
            ans[ind++] = stk.pop();
        }
        return ans;
    }
    //bfs traversal of topological sort
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int indegree[] = new int[V];
        int topoans[] = new int[V];
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
        
        int ind=0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            topoans[ind++] = node;
            
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return topoans;
    }
}