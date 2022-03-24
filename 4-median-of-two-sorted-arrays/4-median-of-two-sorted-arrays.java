class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int med1=0,med2=0;
        for(int k=0;k<=(nums1.length+nums2.length)/2;k++){
            med1=med2;
            if(i==nums1.length){
                med2=nums2[j++];
            }
            else if(j==nums2.length){
                med2=nums1[i++];
            }
            else if(nums1[i]<nums2[j]){
                med2=nums1[i++];
            }
            else{
                med2=nums2[j++];
            }
        }
        if((nums1.length+nums2.length)%2==0) 
            return (double)(med1+med2)/2.0;
        return (double)med2;
    }
}