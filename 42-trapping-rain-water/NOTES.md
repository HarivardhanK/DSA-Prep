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
```
​
### Two Pointer:
```
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
```