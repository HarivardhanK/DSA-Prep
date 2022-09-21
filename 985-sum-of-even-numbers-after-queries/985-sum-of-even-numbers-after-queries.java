class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        for(int ele: nums) 
            if(ele%2 == 0)  sum += ele;
        
        int i = 0;
        for(int[] query: queries) {
            int ind = query[1], val = query[0];
            if((nums[ind]+val)%2 == 0) {
                if(nums[ind]%2 == 0) sum += val;
                else sum += nums[ind]+val;
                nums[ind] += val;
            }
            else {
                if(nums[ind]%2 == 0) sum -= nums[ind];
                nums[ind] += val;
            }
            ans[i++] = sum;
        }
        return ans;
    }
}