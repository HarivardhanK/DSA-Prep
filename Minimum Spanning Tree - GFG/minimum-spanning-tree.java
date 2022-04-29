// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java
class DisjointSet{
  static int parent[]; 
  int rank[];
  int n;
  DisjointSet(int n){
    parent = new int[n]; 
    rank = new int[n];
    this.n = n;
    makeset();
  }
  void makeset(){
    for(int i = 0;i<n;i++) {
    	parent[i] = i; 
    	rank[i] = 0; 
    }
  }
  static int findPar(int u) {
		if(u==parent[u]) return u;
		return parent[u] = findPar(parent[u]); 
	}
	void union(int u, int v) {
		u = findPar(u); 
		v = findPar(v);
		if(rank[u] < rank[v]) {
    	parent[u] = v;
    }
    else if(rank[v] < rank[u]) {
    	parent[v] = u; 
    }
    else {
    	parent[v] = u;
    	rank[u]++; 
    }
	}
}
class Node {
	private int u;
    private int v;
    private int weight;
    
    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}
class Solution
{
    static int kruskalsalgo(ArrayList<Node> adj, int N)
    {
      DisjointSet dset = new DisjointSet(N);
      Collections.sort(adj, new SortComparator());
        

        int costMst = 0;
        ArrayList<Node> mst = new ArrayList<Node>();
        for(Node it: adj) {
        	if(dset.findPar(it.getU()) != dset.findPar(it.getV())) {
        		costMst += it.getWeight(); 
        		mst.add(it); 
        		dset.union(it.getU(), it.getV()); 
        	}
        } 
        return costMst;
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjmat) 
    {
        ArrayList<Node> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(ArrayList<Integer> a:adjmat.get(i)){
               adj.add(new Node(i,a.get(0),a.get(1)));
            }
        }
        return kruskalsalgo(adj,V);
    }
}
class SortComparator implements Comparator<Node> {
	@Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.getWeight() < node2.getWeight()) 
            return -1; 
        if (node1.getWeight() > node2.getWeight()) 
            return 1; 
        return 0; 
   

    } 
} 

