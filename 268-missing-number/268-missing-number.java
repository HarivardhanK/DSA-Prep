class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int missingNumber(int[] nums) {
        //A1: brute : checking the element of [0,n] is present in arr or not
        //TC: O(n^2) SC: O(1)
        
        //A2: sorting : sort then array first and then search for each ele in[0,n] 
        //TC: O(nlogn) SC: O(1)
        
        //A3: using sets : put the all elements of arr in set and then
        //iterate through [0,n] search in the set 
        //TC: O(n) SC: O(n)
        
        //A4: using cyclic sort
        int i = 0;
        while(i<nums.length){
            int curr = nums[i];
            if(curr<nums.length && nums[curr]!=nums[i]){
                swap(nums, curr, i);
            }
            else{
                i++;
            }
        }
        
        for(i = 0; i < nums.length; i++){
            if(i!=nums[i]) return i;
        }
        return nums.length;
    }
}