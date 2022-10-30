class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dir= {{1, 0},{0,1},{-1,0},{0,-1}};
        
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int[] v: vis) Arrays.fill(v, (int)1e9);
        int dist = 0;
        // {i, j, k operations}
        q.offer(new int[]{0,0,0});
        vis[0][0] = 0;
        
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                int[] node = q.poll();
                if(node[0] == n-1 && node[1] == m-1) return dist;
                for(int[] d: dir) {
                    int nr = node[0]+d[0], nc = node[1]+d[1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        int newK = node[2]+grid[nr][nc];
                        if(newK > k) continue;
                        
                        if(vis[nr][nc] <= newK) continue;
                        
                        vis[nr][nc] = newK;
                        q.offer(new int[]{nr, nc, newK});
                    }   
                }
            }
            dist++;
        }
        return -1;
    }
}