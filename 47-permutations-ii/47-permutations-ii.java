class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
    }
    private void solve(int nums[], int ind, Set<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> arr = new ArrayList<>();
            for(int ele:nums) arr.add(ele);
            ans.add(arr);
            return;
        }
        
        for(int i=ind;i<nums.length;i++){
            swap(nums,ind,i);
            solve(nums,ind+1,ans);
            swap(nums,ind,i);
        }
    }
    private void swap(int nums[], int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private List<List<Integer>> permute(int[] nums) {
        //Approach 1: use map to keep track of elements that have been taken as constraints are 1 <= nums.length <= 6
    
        //Appraoch 2: use swap, swap the i in for (ind to n-1) 
        // if ind == nums.length ans into the ans
        
        Set<List<Integer>> ans = new HashSet<>();
        solve(nums, 0, ans);
        return new ArrayList<>(ans);
    }
}