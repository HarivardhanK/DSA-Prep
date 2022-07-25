class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = -1, e = -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
                s = mid;
            }
        }
        if(s == -1 || nums[s] != target) return new int[]{-1, -1};
        
        lo = 0; hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <= target) {
                lo = mid + 1;
                e = mid;
            }
            else {
                hi = mid - 1;
            }
        }
        return new int[]{s, e};
    }
}