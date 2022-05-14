class Solution {
    private List<List<Pair<Integer, Integer>>> createGraph(int[][] times, int n){
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        
        for(int time[] : times){
            adj.get(time[0]).add(new Pair<>(time[1],time[2]));
        }
        
        return adj;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer, Integer>>> adj = createGraph(times,n);
        
        int dis[]  = new int[n+1];
        Arrays.fill(dis,(int)1e9);
        dis[k] = 0;
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(k,0));
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            
            for(Pair<Integer, Integer> pair : adj.get(p.getKey())){
                if(dis[pair.getKey()] > p.getValue() + pair.getValue()){
                    dis[pair.getKey()] = p.getValue() + pair.getValue();
                    q.offer(new Pair<>(pair.getKey(), dis[pair.getKey()]));
                }
            }
        }
        
        int max = (int)-1e9;
        for(int i=1;i<dis.length;i++){
            if(dis[i]==(int)1e9) return -1;
            max = Math.max(max, dis[i]);
        }
        return max;
    }
}