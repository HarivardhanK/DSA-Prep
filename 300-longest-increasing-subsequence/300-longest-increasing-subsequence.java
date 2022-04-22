class Solution {
    private int binsearch(List<Integer> arr, int s, int e,int target){
        while(s<e){
            int mid=s+(e-s)/2;
            if(arr.get(mid)==target) return mid;
            else if(arr.get(mid)<target) s++;
            else e--;
        }
        return s;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>arr.get(arr.size()-1)){
                arr.add(nums[i]);
            }
            else{
                int ind = binsearch(arr,0,arr.size()-1,nums[i]);
                arr.set(ind,nums[i]);
            }
        }
        return arr.size();
    }
}