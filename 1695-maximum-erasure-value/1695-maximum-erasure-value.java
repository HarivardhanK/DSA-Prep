class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] presum = new int[nums.length];
        //map stores -> (element, index)
        Map<Integer, Integer> map = new HashMap<>();
        presum[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            presum[i] = nums[i] + presum[i - 1];
            max = Math.max(max, nums[i]);
        }
        
        for(int i = -1, j = 0; j < nums.length; j++) {
            if(map.containsKey(nums[j])) {
                i = Math.max(i, map.get(nums[j]));
            }
            map.put(nums[j], j);
            if(i != -1)
                max = Math.max(max, presum[j] - presum[i]);
            else
                max = Math.max(max, presum[j]);
        }
        return max;
    }
}