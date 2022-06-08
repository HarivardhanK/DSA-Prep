class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        //nums1 = first element and nums2 = second majority
        int nums1 = -1, nums2 = -1;
        //c1 = count of first and c2 = count of second majority element
        int c1 = 0, c2 = 0;
        
        for(int ele: nums) {
            if(ele == nums1) {
                c1++;
            }
            else if(ele == nums2) {
                c2++;
            }
            else if(c1 == 0) {
                nums1 = ele;
                c1 = 1;
            }
            else if(c2 == 0) {
                nums2 = ele;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = c2 = 0;
        for( int ele: nums) {
            if(nums1 == ele){
                c1++;
            }
            else if(nums2 == ele) {
                c2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(c1 > n/3) {
            ans.add(nums1);
        }
        if(c2 > n/3) {
            ans.add(nums2);
        }
        return ans;
   }
}