class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // variant of 3 sum
        Arrays.sort(nums);
        int n = nums.length;
        int closestsum = (int)1e9;
        
        for(int a =0;a < n-2; a++) {
            int b = a+1, c = n-1;
            while(b < c) {
                int sum = nums[a]+nums[b]+nums[c];
                if(Math.abs(target-sum) < Math.abs(target-closestsum)) {
                    closestsum = sum;
                }
                if(sum == target) return target;
                else if(sum < target) b++;
                else c--;
            }    
        }
        return closestsum;
        //-4 -1 1 2 
    }
}