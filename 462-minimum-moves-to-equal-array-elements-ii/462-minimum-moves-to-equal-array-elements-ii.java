class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[(nums.length -1)/2];
        int ans = 0;
        for(int ele: nums) {
            ans += Math.abs(mid - ele);
        }
        return ans;
    }
}