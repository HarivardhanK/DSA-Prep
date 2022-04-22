class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int lis[] = new int[n];
        //base case filling 0's in nth row -- by default the values are 0
        //nested loops
        int max=1;
        Arrays.fill(lis,1);
        for(int ind=0;ind<n;ind++){
            for(int prevind=0;prevind<ind;prevind++){
                if(nums[ind]>nums[prevind]){
                    if(lis[ind]<1+lis[prevind])
                        lis[ind]=1+lis[prevind];
                }
            }
            max=Math.max(max,lis[ind]);
        }
        return max;
    }
}