class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int var2 = (int)-1e10;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<var2) return true;
            
            while(!stk.isEmpty() && nums[i]>stk.peek()){
                var2=Math.max(var2,stk.pop());
            }
            stk.push(nums[i]);
        }
        return false;
    }
}