class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> s = new ArrayDeque<>();
        int ansindex=0;
        for(int i=0;i<nums.length;i++){
            //removing all indices which are bound
            if(!s.isEmpty() && s.peek()==i-k)
                s.poll();
            
            //removing all index elements which are less than the current ele
            while(!s.isEmpty() && nums[s.peekLast()]<=nums[i])
                s.pollLast();
            
            s.offer(i);
            
            if(i>=k-1)
                ans[ansindex++]=nums[s.peek()];
        }
        return ans;
    }
}