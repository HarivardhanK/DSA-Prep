class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int ans[] = new int[nums.length];
        for(int i=2*nums.length-1;i>=0;i--){
            while(stk.size()>0 && nums[stk.peek()]<=nums[i%nums.length]) stk.pop();
            if(stk.size()>0) ans[i%nums.length]=nums[stk.peek()];
            else ans[i%nums.length]=-1;
            stk.push(i%nums.length);
        }
        return ans;
    }
}