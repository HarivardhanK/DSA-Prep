class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
            while(i<nums.length && nums[i]%2==0) i++;
            while(j>=0 && nums[j]%2!=0) j--;
            if(i>=nums.length || j<=0 || i>=j) break;
            if(nums[i]%2!=0 && nums[j]%2==0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
        }
        return nums;
    }
}