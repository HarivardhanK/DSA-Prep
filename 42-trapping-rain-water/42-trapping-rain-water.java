class Solution {
    public int trap(int[] height) {
        //Two pointer appraoch
        int l=0,r=height.length-1;
        int lmax=height[l],rmax=height[r];
        int ans=0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=lmax) lmax=height[l];
                else ans+=(lmax-height[l]);
                l++;
            }
            else{
                if(height[r]>=rmax) rmax=height[r];
                else ans+=(rmax-height[r]);
                r--;
            }
        }
        return ans;
    }
}