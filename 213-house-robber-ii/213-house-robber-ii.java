class Solution {
    public int rob(int[] nums) {
        int curr=0,prev1=nums[0],prev2=0;
        int robhouse1=0;
        //not including the last index house 
        //only we are including the 0 to n-1
        for(int i=1;i<nums.length-1;i++){
            int pick=nums[i];
            if(i>1) pick+=prev2;
            int unpick=prev1;
            curr = Math.max(pick,unpick);
            prev2=prev1;
            prev1=curr;
        }
        robhouse1=prev1;
        //not including the 0th index house 
        //only we are including the 1 to n
        curr=0;
        prev1=0;
        prev2=0;
         for(int i=1;i<nums.length;i++){
            int pick=nums[i]+prev2;
            int unpick=prev1;
            curr = Math.max(pick,unpick);
            prev2=prev1;
            prev1=curr;
        }
        return Math.max(robhouse1,prev1);
    }
}