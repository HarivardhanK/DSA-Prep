class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
                if(a.length()==b.length()) return a.compareTo(b);
                return Integer.compare(a.length(),b.length());
            }
        );
        for(String n:nums){
            pq.offer(n);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}