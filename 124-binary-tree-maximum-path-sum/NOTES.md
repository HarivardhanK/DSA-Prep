**First Solution:**
​
```
class Solution {
int maxpath;
private int findmaxpath(TreeNode root){
if(root==null) return 0;
int lmax=findmaxpath(root.left);
int rmax=findmaxpath(root.right);
int pathsum=root.val;
if(lmax>0) pathsum+=lmax;
if(rmax>0) pathsum+=rmax;
int path = root.val+Math.max((lmax>0)?lmax:0 , (rmax>0)?rmax:0);
maxpath=Math.max(maxpath,pathsum);
return path;
}
public int maxPathSum(TreeNode root) {
maxpath=root.val;
findmaxpath(root);
return maxpath;
}
}
```
​