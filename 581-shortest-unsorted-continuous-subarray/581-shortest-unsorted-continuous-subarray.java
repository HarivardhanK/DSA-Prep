class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int ns[] = Arrays.copyOf(nums,nums.length);
        Arrays.sort(ns);
        int start=0,end=nums.length-1;
        while(start<nums.length && ns[start]==nums[start]) start++;
        while(end>=0 && ns[end]==nums[end]) end--;
        int ans = end-start+1;
        return ans<0?0:ans;
    }
}