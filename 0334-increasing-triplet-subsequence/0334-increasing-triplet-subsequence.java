class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int j = Integer.MAX_VALUE, k = Integer.MAX_VALUE;        
        for(int i =0; i< nums.length;i++) {
            if(j >= nums[i]) {
                j = nums[i];
            }
            else if(k >= nums[i]) {
                k = nums[i];
            }
            else return true;
        }
        return false;
    }
}