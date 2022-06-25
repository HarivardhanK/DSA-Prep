class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length && count <= 1; i++) {
            if(nums[i - 1] > nums[i]) {
                count++;
                if(i-2 < 0 || nums[i - 2] <= nums[i]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
            
        }
        if(count <= 1) return true;
        
        return false;
    }
}

/*
[5, 3, 4, 8, 9, 7]
[3,4,2,3]
*/