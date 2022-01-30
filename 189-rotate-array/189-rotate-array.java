class Solution {
    public void rotate(int[] nums, int k) {
        if(k%nums.length==0) return;
        k=k%nums.length;
        int temp[]=new int[k];
        int j=k-1;
        for(int i=nums.length-1;j>=0 && i>nums.length-k-1;i--)
            temp[j--] = nums[i];
        for(int i=nums.length-k-1;i>=0;i--)
            nums[i+k]=nums[i];
        for(int i=0;i<k;i++)
            nums[i]=temp[i];
        // for(int i=0;i<nums.length;i++)
        //     System.out.println(nums[i]);
    }
}