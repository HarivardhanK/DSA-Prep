class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] build = new int[2*buildings.length][2];
        int ind = 0;
        for(int[] building: buildings) {
            build[ind][0] = building[0];
            // -ve height for the start of the building
            build[ind][1] = -building[2];
            ind++;
            // +ve height for the end of the building
            build[ind][0] = building[1];
            build[ind][1] = building[2];
            ind++;
        }
        Arrays.sort(build, (a,b)-> (a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> ans = new ArrayList<>();
        int currht = 0;
        pq.offer(0);
        for(int b[]: build) {
            
            if(b[1] < 0) pq.offer(-b[1]); // start of the building
            else pq.remove(b[1]);  // end of the building
            
            if(currht != pq.peek()) {
                ans.add(Arrays.asList(new Integer[]{b[0], pq.peek()}));
                currht = pq.peek();
            }
        }
        return ans;
    }
}