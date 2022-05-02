class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        //inplace algorithm
        int i=0,j=nums.length-1;
        while(i<j){
            while(i<nums.length && nums[i]%2==0) i++;
            while(j>=0 && nums[j]%2!=0) j--;
            if(i==nums.length || j<0 || i>j) break;
            swap(nums,i,j);
            i++;j--;
        }
        return nums;
    }
}