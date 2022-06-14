class Solution {
    private void solve(int[] nums, int tar, int ind, List<Integer> p, List<List<Integer>> ans) {
        if(tar == 0)
            ans.add(new ArrayList<>(p));
        for(int i = ind; i < nums.length; i++) {
            if(i != ind && nums[i] == nums[i - 1]) continue;
            if(nums[i] <= tar){
                p.add(nums[i]);
                solve(nums, tar - nums[i], i + 1, p, ans);
                p.remove(p.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}