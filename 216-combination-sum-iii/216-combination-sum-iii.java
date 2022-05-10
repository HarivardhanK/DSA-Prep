class Solution {
    private void solve(int k, int sum, int start, List<Integer> arr, List<List<Integer>> ans){
        if(k==0 && sum==0){
            ans.add(new ArrayList<>(arr));
            return ;
        }
        else if(sum<0) return ;
        
        for(int i=start; i<=9;i++){
            arr.add(i);
            solve(k-1, sum-i,i+1,arr,ans);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k , n, 1, new ArrayList<>(), ans);
        return ans;
    }
}