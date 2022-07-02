class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int hlen = horizontalCuts.length;
        int vlen = verticalCuts.length;
        
        int maxh = Math.max(horizontalCuts[0], h - horizontalCuts[hlen - 1]);
        int maxv = Math.max(verticalCuts[0], w - verticalCuts[vlen - 1]);
        
        for(int i = 1; i < hlen; i++) {
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for(int i = 1; i < vlen; i++) {
            maxv = Math.max(maxv, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int)((long)maxh * maxv % 1000000007);
    }
}