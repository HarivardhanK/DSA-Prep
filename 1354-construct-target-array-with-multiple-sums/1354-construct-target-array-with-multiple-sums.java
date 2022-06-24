class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        //pushing all the elements to pq
        //calculating the total sum
        long tsum = 0;
        for(int t: target) {
            pq.offer(t);
            tsum += t;
        }
        
        while(true) {
            int max = pq.poll();
            tsum -= max;
            
            if(max == 1 || tsum == 1)
                return true;
            
            if(max < tsum || tsum == 0 || max%tsum == 0)
                return false;
            
            max %= tsum;
            
            tsum += max;
            pq.offer(max);
        }
    }
}