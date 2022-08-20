class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1] - a[1]);
        
        int distance = startFuel, no_refills = 0, i = 0;
        while(distance < target) {
            while(i < n && stations[i][0] <= distance) 
                pq.offer(stations[i++]);
            
            if(pq.size() == 0) return -1;
            
            distance += pq.poll()[1];
            no_refills++;
        }
        return no_refills;
    }
}


