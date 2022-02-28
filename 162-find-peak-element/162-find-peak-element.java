class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(mid>0 && mid+1<nums.length && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            if(mid+1<nums.length && nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
}