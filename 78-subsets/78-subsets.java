class Solution {
    private void solve(int nums[], int i, List<Integer> p, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(p));
            return;
        }
        
        p.add(nums[i]);
        solve(nums,i+1,p,ans);
        p.remove(p.size()-1);
        
        solve(nums,i+1,p,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        solve(nums, 0, new ArrayList<>(), ans);
        
        return ans;
    }
}