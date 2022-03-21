class Solution {
    public void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] nums) {
        //Brute force is count 0,1 and 2  => counting sort
        //(or) directly sort using predefined func
        //Dutch national flag approach with three pointers
        //two pointer approach: keep a pointer for 0-- starting 
        //                                         2-- ending
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
            
        }
    }
}