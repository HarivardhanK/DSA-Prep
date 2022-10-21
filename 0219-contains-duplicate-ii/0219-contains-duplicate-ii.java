class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // return the previously mapped value to key or
            // null if key is not present 
            Integer ord = map.put(nums[i], i);
            if(ord != null && i-ord <= k) return true;
        }
        return false;
    }
}