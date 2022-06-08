class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> en: map.entrySet()) {
            if(en.getValue() > n/3) {
                ans.add(en.getKey());
            }
        }
        return ans;
        
        // Arrays.sort(nums);
        // int count = 0;
        // List<Integer> ans = new ArrayList<>();
        // for(int i = 0; i < nums.length; i++) {
        //     if(i > 0 && nums[i] == nums[i-1]) {
        //         count++;
        //     }
        //     else {
        //         if(count > nums.length/3) 
        //             ans.add(nums[i]);
        //         count = 1;
        //     }            
        // }
        // if((ans.size() == 0 || ans.get(ans.size() - 1) != nums[nums.length - 1]) && count > nums.length/3) 
        //     ans.add(nums[nums.length - 1]);
        // return ans;
    }
}