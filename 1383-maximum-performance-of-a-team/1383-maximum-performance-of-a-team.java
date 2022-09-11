class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineer = new int[n][2];
        for(int i = 0;i < n; i++) {
            engineer[i][0] = speed[i];
            engineer[i][1] = efficiency[i];
        }
        Arrays.sort(engineer, (a, b) -> b[1] - a[1]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        long maxPer = 0, totalspeed = 0;
        
        
        for(int[] eng: engineer) {
            if(pq.size() == k) {
                int[] slowguy = pq.poll();
                
                totalspeed -= slowguy[0];
            }
            pq.offer(eng);
            totalspeed += eng[0];
            long perwithnewguy = totalspeed*(long)eng[1];
            maxPer = Math.max(maxPer, perwithnewguy);
        }
        return (int)(maxPer%1000000007);
    }
}