class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<=j){
            max=Math.max(max,Math.min(height[j],height[i])*(j-i));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}