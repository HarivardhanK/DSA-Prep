class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        
        int lis[] = new int[n];
        int hash[] = new int[n];
        int max=1,lastind=n-1;
        Arrays.fill(lis,1);
        
        for(int ind=0;ind<n;ind++){
            hash[ind]=ind;
            for(int prevind=0;prevind<ind;prevind++){
                if(nums[ind]%nums[prevind]==0 && lis[ind]<1+lis[prevind]){
                    lis[ind]=1+lis[prevind];
                    hash[ind] = prevind;    
                }
            }
            if(max<lis[ind]){
              max=lis[ind];
              lastind=ind;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[lastind]);
        while(hash[lastind] != lastind){
            lastind=hash[lastind];
            ans.add(nums[lastind]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
        