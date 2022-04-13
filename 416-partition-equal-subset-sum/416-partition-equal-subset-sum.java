class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int ele:nums) sum+=ele;
        if((sum&1)==1) return false;//if odd we can't divide into two
        int s=sum/2;
        boolean[] prev = new boolean[s+1];
        //if we can get one subset with sum of totalsum/2 then
        //we can partition the array into two
        //if(s==0) fill true
        prev[0] = true;
        if(nums[0]<=s) prev[nums[0]]=true;
        for(int i=1;i<n;i++){
            boolean[] curr = new boolean[s+1];
            curr[0] = true;
            for(int j=1;j<=s;j++){
                boolean nopick=prev[j];
                
                boolean pick=false;
                if(nums[i]<=j)
                    pick=prev[j-nums[i]];
                
                curr[j]=nopick||pick;
            }
            prev=curr;
        }
        return prev[s];
    }
}