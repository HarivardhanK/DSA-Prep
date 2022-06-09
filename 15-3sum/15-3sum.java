class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1;
                while(lo < hi) {
                    if(nums[lo] + nums[hi] == -nums[i]) {
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        while(lo < hi && nums[lo] == nums[lo + 1]) 
                            lo++;
                        while(hi > lo && nums[hi] == nums[hi - 1]) 
                            hi--;
                        lo++; hi--;
                    }
                    else if(nums[lo] + nums[hi] < -nums[i]) 
                        lo++;
                    else 
                        hi--;
                }
            }
        }
        return ans;
    }
}