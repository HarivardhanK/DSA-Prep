class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            // we take the decision based on the mid's value
            // if mid is even then we check for the next element 
            // before the non-rep no. first occ is at even index and 
            // sec occ is at odd index
            if((mid&1) == 0) {
                if(mid+1 < nums.length && nums[mid] == nums[mid+1]) lo = mid+1; 
                else hi = mid-1;
            }
            else{
                if(mid+1 < nums.length && nums[mid] == nums[mid+1]) hi = mid-1;
                else lo = mid+1;
            }
        }
        return nums[lo];
    }
}