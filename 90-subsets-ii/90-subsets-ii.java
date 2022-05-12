class Solution {
    private void solve(int nums[], int ind, List<Integer> p, List<List<Integer>> ans){
        ans.add(new ArrayList<>(p));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            
            p.add(nums[i]);
            solve(nums,i+1,p,ans);
            p.remove(p.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}