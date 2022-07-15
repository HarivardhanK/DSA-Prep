class Solution {
    private List<List<int[]>> createGraph(int[][] roads, int n) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());
        
        for(int[] road: roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        return adj;
    }
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = createGraph(roads, n);
        int MOD = (int)1e9 + 7;
        
        //apply dijkstra's algo
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int[] ways = new int[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        dis[0] = 0;
        ways[0] = 1;
        
        while(pq.size() > 0) {
            int[] node = pq.poll();
            if(node[1] <= dis[node[0]])
            for(int[] it: adj.get(node[0])) {
                if(dis[node[0]] + it[1] < dis[it[0]]) {
                    dis[it[0]] = dis[node[0]] + it[1];
                    
                    pq.offer(new int[]{it[0], dis[it[0]]});
                    
                    ways[it[0]] = ways[node[0]];
                }
                else if(dis[node[0]] + it[1] == dis[it[0]]) {
                    ways[it[0]] = (ways[it[0]] + ways[node[0]])% MOD;
                }
                
            }
        }
        return ways[n-1];
    }
}