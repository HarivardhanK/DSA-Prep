class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
           int mid= left+(right-left)/2;
            if(nums[mid]==target) return mid;
            
            //skipping the duplicates from start and end
            if(nums[left]==nums[mid]&& nums[right]==nums[mid]){ left++;right--;}
            else if(nums[left]<=nums[mid]){
                if(nums[left]<=target && nums[mid]>target) right=mid-1;
                else left=mid+1;
            }
            else{
                if(nums[right]>=target && nums[mid]<target) left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}