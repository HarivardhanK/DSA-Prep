// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> d = new ArrayList<Integer>();
            
            for(int i=0;i<p;i++)
            {
                a.add(sc.nextInt());
                b.add(sc.nextInt());
                d.add(sc.nextInt());
            }
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.solve(n, p, a, b, d); 
            System.out.println(ans.size());
            for (int i=0;i<ans.size();i++){ 
                System.out.println(ans.get(i).get(0)+" "+ans.get(i).get(1)+" "+ans.get(i).get(2)); 
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    private void dfs(int node, boolean vis[], List<List<int[]>> adj, int res[]){
        vis[node] = true;
        for(int[] it: adj.get(node)){
            if(!vis[it[0]]){
                res[0] = it[0];
                res[1] = Math.min(res[1], it[1]);
                
                dfs(it[0], vis, adj, res);
            }
        }
    }
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b 
    ,ArrayList<Integer> d) { 
        int in[] = new int[n+1];
        int out[] = new int[n+1];
        boolean vis[] = new boolean[n+1];
        
        List<List<int[]>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        //creating the graph
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<a.size();i++){
            out[a.get(i)] = 1;
            in[b.get(i)] = 1;
            adj.get(a.get(i)).add(new int[]{b.get(i), d.get(i)});
        }
        
        for(int i=1;i<=n;i++){
            if(in[i] == 0 && out[i] == 1 && !vis[i]){
                int res[] = new int[2];// res[0] -> endNode and res[1] -> minDiameter
                res[0] = i;
                res[1] = (int)1e9;
                dfs(i, vis, adj, res);
                ArrayList<Integer> component = new ArrayList<>();
                component.add(i);//start of the component
                component.add(res[0]);//end of the component
                component.add(res[1]);//minimum diameter
                ans.add(component);
            }
        }
        return ans;
     }
} 