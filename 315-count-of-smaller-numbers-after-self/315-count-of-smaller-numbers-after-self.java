class Solution {
    private int[] freq = new int[20005];
	private int N=20002;
    public int getSmallerElements(int val){
        int ans =0;
        while(val>0){
            ans+=freq[val];
            val -= (val & -val);
        }
        return ans;
    }
    
   public void update_frequency(int val){
        while(val<=N){
            freq[val]+=1;
            val+=(val& -val);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int  i,j,n,shift;
        n = nums.length;
        shift = nums[0];
        for(i=1;i<n;i++){
            shift= Math.min(shift,nums[i]);
        }
       Arrays.fill(freq,0);
        List<Integer> ans = new ArrayList();
        int temp;
        for(i=n-1;i>=0;i--){
			 //SHIFTING
             j=nums[i]+Math.abs(shift)+1;
           
            ans.add(getSmallerElements(j-1));
            update_frequency(j);
        }
        Collections.reverse(ans);
        return ans;
    }
}