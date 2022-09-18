class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1; 
        int ans = 0;
        int lmax = height[0], rmax = height[n-1];
        while(l < r) {
            if(height[l] <= height[r]) {
                if(height[l] >= lmax) lmax = height[l];
                else ans += lmax-height[l];
                l++;
            }
            else {
                if(height[r] >= rmax) rmax = height[r];
                else ans += rmax - height[r];
                r--;
            }
            // System.out.println(ans+" "+l+" "+r);
        }
        return ans;
    }
}