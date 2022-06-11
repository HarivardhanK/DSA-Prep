class Solution {
    public int minOperations(int[] nums, int x) {
        int tsum = -x;//total sum
        for(int ele: nums)
            tsum += ele;
          // since all elements are positive, we have to take all of them
        if(tsum == 0) return nums.length;
        
        int res = -1, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        //find the maximum subarray of sum = tsum - x
        //so that we can get the min num of operations
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - tsum)){
                res = Math.max(res, i - map.get(sum - tsum));
            }
            // no need to check containsKey since sum is unique
            map.put(sum, i);
        }
        
        return (res == -1)?-1 :nums.length - res;
    }
}