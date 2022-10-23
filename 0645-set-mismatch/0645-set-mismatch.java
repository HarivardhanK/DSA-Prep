class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int crt = nums[i];
            if(nums[crt-1] != nums[i]) {
                int t = nums[crt-1];
                nums[crt-1] = nums[i];
                nums[i] = t;
            }
            else i++;
        }
        
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) return new int[]{nums[i], i+1};
        }
        return new int[]{-1, -1};
    }
}