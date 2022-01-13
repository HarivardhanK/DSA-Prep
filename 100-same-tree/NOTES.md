**1. submitted clean code**
​
**2. my solution:**
​
```
class Solution {
public boolean isSameTree(TreeNode p, TreeNode q) {
if(p==null && q!=null || p!=null && q==null) return false;
if(p==null && q==null) return true;
if(p.val!=q.val) return false;
boolean lef=isSameTree(p.left,q.left);
boolean rig=isSameTree(p.right,q.right);
return lef && rig;
}
}
```