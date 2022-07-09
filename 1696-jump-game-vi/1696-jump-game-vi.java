class Solution {
    public int maxResult(int[] nums, int k) {
        //int[2] -> index 0 = index of the nums , index 1 = value at index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[1] - a[1]);
        int max = nums[0];
        
        pq.offer(new int[]{0, nums[0]});
        
        for(int i = 1; i < nums.length; i++) {
            
            while(i - pq.peek()[0] > k ) 
                pq.poll();
            
            max = pq.peek()[1] + nums[i];
            pq.offer(new int[]{i, max});
        }
        return max;
    }
}