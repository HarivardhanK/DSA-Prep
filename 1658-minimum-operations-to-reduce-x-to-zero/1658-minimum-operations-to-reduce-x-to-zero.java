class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int ele:nums) sum+=ele;
        if(sum<x) return -1;
        int rightsum=0, leftsum=0;
        int n=nums.length,res = (int)1e9;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=n-1;i>=0;i--){
            if(nums[i]>x  || rightsum>=x) break;
            rightsum+=nums[i];
            map.put(rightsum,n-i);
            if(rightsum==x) res = Math.min(res,n-i);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>x || leftsum>=x) break;
            leftsum+=nums[i];
            if(map.containsKey(x-leftsum))
                res = Math.min(res,i+1+map.get(x-leftsum));
            if(leftsum==x)
                res = Math.min(res, i+1);
        }
        return res==(int)1e9?-1:res;
    }
}