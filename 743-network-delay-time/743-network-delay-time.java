class Solution {
    class Pair{
        int dist,node;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    private List<List<Pair>> createGraph(int[][] times, int n){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        
        for(int time[] : times){
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }
        return adj;
    }
    public int networkDelayTime(int[][] times, int n, int source) {
        List<List<Pair>> adjlist = createGraph(times,n); 
        int[] distfromSource = new int[n+1];
        Arrays.fill(distfromSource,(int)1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.dist-a.dist));
        
        pq.add(new Pair(source,0));
        distfromSource[source]=0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(Pair it:adjlist.get(p.node)){
                if(( p.dist + it.dist) < distfromSource[it.node]){
                    pq.offer(new Pair(it.node,p.dist+it.dist));
                    distfromSource[it.node] = p.dist + it.dist;
                }
            }
        }
        int max = 0;
        for(int i=1;i<n+1;i++){
            max = Math.max(distfromSource[i],max);
            if(max==(int)1e9) return -1;
        }
        return max;
    }
}