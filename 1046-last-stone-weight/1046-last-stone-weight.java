class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            pq.offer(stone);
        }
        
        while(pq.size()>1){
                pq.offer(Math.abs(pq.poll()-pq.poll()));
        }
        return pq.poll();
    }
}