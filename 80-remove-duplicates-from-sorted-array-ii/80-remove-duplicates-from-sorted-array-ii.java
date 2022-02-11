class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1,count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
            else{
                count=0;
            }
            nums[k]=nums[i];
            if(count<2) k++;
        }
        return k;
    }
}