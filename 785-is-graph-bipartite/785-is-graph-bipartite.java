class Solution {
    private boolean isbipardfs(int i, int[] colors, int[][] graph){
        for(int it:graph[i]){
            if(colors[it]==-1){
                colors[it] = 1-colors[i];
                if(!isbipardfs(it,colors,graph)){
                    return false;
                }
            }
            else if(colors[it]==colors[i]) return false;
        }
        return true;
    }
    private boolean isbiparbfs(int i, int[] colors, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it:graph[node]){
                if(colors[it]==-1){
                    colors[it] = 1-colors[node];
                    q.offer(it);
                }
                else if(colors[it]==colors[node]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];
        //-1 - nocolor, 0 - firstcolor, 1 - second color
        Arrays.fill(colors,-1);
        for(int i=0;i<n;i++){
            if(colors[i]==-1){
                colors[i] = 1;
                if(!isbiparbfs(i,colors,graph)) return false;
            }
        }
        return true;
    }
}