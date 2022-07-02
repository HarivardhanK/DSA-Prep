class Solution {
public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
Arrays.sort(horizontalCuts);
Arrays.sort(verticalCuts);
int hlen = horizontalCuts.length;
int vlen = verticalCuts.length;
int maxh = 0, maxv = 0;
if(hlen == 1) {
maxh = horizontalCuts[0];
}
for(int i = 1; i < hlen; i++) {
maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
}
if(vlen == 1) {
maxv = verticalCuts[0];
}
for(int i = 1; i < vlen; i++) {
maxv = Math.max(maxv, verticalCuts[i] - verticalCuts[i - 1]);
}
if(hlen == 1 && vlen == 1) {
long cake = (maxh * maxv);
return (int)Math.max(cake, (long)(vlen * hlen) - cake) % ((int)1e9 + 7);
}
return (maxh * maxv) % ((int)1e9 + 7);
}
}