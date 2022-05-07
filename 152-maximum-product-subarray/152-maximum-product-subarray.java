class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0],l=0,r=0;
        for(int i=0;i<nums.length;i++){
            l=((l==0)?1:l)*nums[i];
            r=((r==0)?1:r)*nums[nums.length-i-1];
            max_so_far = Math.max(max_so_far,Math.max(l,r));
        }
        return max_so_far;
    }
}