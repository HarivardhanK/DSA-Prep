class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    private void comb(int digits,int sum,Set<Integer> set){
        if(sum==0 && digits==0){
            ans.add(new ArrayList<>(set));
            return;
        }
        if(sum<0 || digits<0) return;
        
        for(int i=1;i<=9;i++){
            if(sum-i<0) break;
            if(!set.contains(i)){
                set.add(i);
                comb(digits-1,sum-i,set);
                set.remove(i);
            }
            
        }
    }
    public List<List<Integer>> combinationSum3(int digits, int sum) {
        comb(digits,sum,new HashSet<>());
        List<List<Integer>> ansarr = new ArrayList<>(ans);
        return ansarr;
    }
}