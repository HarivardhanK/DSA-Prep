class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int maxr[] = new int[n];
        int maxl[] = new int[n];
        maxl[0]=height[0];
        maxr[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            maxl[i]=Math.max(maxl[i-1],height[i]);
            if(n-i>0)
            maxr[n-i-1]=Math.max(maxr[n-i],height[n-i-1]);
        }
        int area[] = new int[n];
        for(int i=0;i<n;i++){
            area[i]=Math.min(maxl[i],maxr[i])-height[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(area[i]>0) ans+=area[i];
        }
        return ans;
    }
}