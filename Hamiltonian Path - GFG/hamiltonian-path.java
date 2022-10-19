//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean isHamil(List<Integer> adj[], Set<Integer> set, int node) {
        set.add(node);
        if(set.size() == adj.length-1) return true;
        
        for(int it: adj[node]) {
            if(!set.contains(it) && isHamil(adj, set, it)) return true;
        }
        set.remove(node);
        return false;
    }
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) { 
        List<Integer>[] adj = new ArrayList[N+1];
        for(int i = 0;i < N+1; i++) adj[i] = new ArrayList<Integer>();
        
        for(ArrayList<Integer> edge: Edges) {
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        Set<Integer> set = new HashSet<>();
        for(int i= 1; i < N+1; i++)
            if(isHamil(adj, set, i)) return true;
        return false;
    }
} 