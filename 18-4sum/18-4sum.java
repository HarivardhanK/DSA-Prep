class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for(int j = i + 1; j < nums.length; j++){
                    
                    if(j == i+1 || (j > 0 && nums[j] != nums[j - 1])){
                        int lo = j + 1, hi = nums.length - 1;
                        
                        while(lo < hi) {
                            if(nums[lo] + nums[hi] == target-(nums[i] + nums[j])) {
                                ans.add(Arrays.asList(nums[i],nums[j], nums[lo], nums[hi]));

                                //ignores the duplicates
                                while(lo < hi && nums[lo] == nums[lo + 1]) 
                                    lo++;
                                while(hi > lo && nums[hi] == nums[hi - 1]) 
                                    hi--;
                                lo++; hi--;
                            }
                            else if(nums[lo] + nums[hi] < target-(nums[i] + nums[j])) 
                                lo++;
                            else 
                                hi--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}