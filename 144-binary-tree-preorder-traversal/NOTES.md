# Recursive Solution:
​
```
class Solution {
public List<Integer> preorderTraversal(TreeNode root) {
if(root==null){
return new ArrayList<Integer>();
}
ArrayList<Integer> ans = new ArrayList<>();
ans.add(root.val);
if(root.left!=null)
ans.addAll(preorderTraversal(root.left));
// preorderTraversal(root.left);
if(root.right!=null)
ans.addAll(preorderTraversal(root.right));
// preorderTraversal(root.right);
return ans;
}
}
```
​