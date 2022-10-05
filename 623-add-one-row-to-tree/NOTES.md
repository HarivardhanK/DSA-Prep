```
class Solution {
public TreeNode addOneRow(TreeNode root, int val, int depth) {
if(root==null) return root;
if(depth == 1){
TreeNode newNode = new TreeNode(val,root,null);
return newNode;
}
if(depth == 2){
TreeNode newNodeleft = new TreeNode(val,root.left,null);
TreeNode newNoderight = new TreeNode(val,null,root.right);
root.left = newNodeleft;
root.right = newNoderight;
return root;
}
root.left = addOneRow(root.left, val, depth-1);
root.right = addOneRow(root.right, val, depth-1);
return root;
}
}
```