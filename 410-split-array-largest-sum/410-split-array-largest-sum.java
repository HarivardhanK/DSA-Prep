class Solution {
    public int minSubarrayRequired(int mid, int[] nums){
        int currsum=0;
        int spilts=0;
        for(int i:nums){
            if(currsum+i<=mid){
                currsum+=i;
            }
            else{
                currsum=i;
                spilts++;
            }
        }
        return spilts+1;
    }
    public int splitArray(int[] nums, int m) {
        int sum=0,max=-1;
        for(int i:nums){
            max=Math.max(max,i);
            sum+=i;
        }
        int left=max, right=sum, res=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(minSubarrayRequired(mid,nums)<=m){
                res=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return res;
    }
}