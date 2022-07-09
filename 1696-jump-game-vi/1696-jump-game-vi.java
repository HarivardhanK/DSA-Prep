class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offer(0);
        
        // iterate from the 1 to length of array
        for(int i = 1; i < nums.length; i++) {
            
            nums[i] += nums[dq.peekFirst()];
            
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) 
                dq.pollLast();
            
            dq.offerLast(i);
            
            if(i - dq.peekFirst() >= k) 
                dq.pollFirst();
        }
        
        return nums[nums.length - 1];
    }
}