class Solution {
    private void solve(int[] nums, int tar, int i, List<Integer> p, List<List<Integer>> ans) {
        if(tar == 0 && i == nums.length) {
            ans.add(new ArrayList<>(p));
            return;
        }
        if(i == nums.length) return;
        
        if(tar >= nums[i]) {
            p.add(nums[i]);
            solve(nums, tar - nums[i], i, p, ans);
            p.remove(p.size() - 1);
        }
        solve(nums, tar, i + 1, p, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}