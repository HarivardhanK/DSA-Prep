class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String s = ""+nums[i];
            if(i+1<nums.length && nums[i+1]==nums[i]+1){
                s+="->";
            }
            boolean flag=false;
            int j=i;
            while(j+1<nums.length && nums[j+1]==nums[j]+1){
                j++;
                flag=true;
            }
            if(flag)
                s+=nums[j];
            i=j;
            ans.add(s);
        }
        return ans;
    }
}