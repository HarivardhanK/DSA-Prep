# Iterative Solution:
while converting a Recursive procedure to iterative we need an explicit stack.
​
# Recursive Solution:
​
```
class Solution {
public List<Integer> inorderTraversal(TreeNode root) {
//Inorder : left root right
//using recursion:
if(root==null)
return new ArrayList<Integer>();
List<Integer> ans = new ArrayList<Integer>();
ans.addAll(inorderTraversal(root.left));
ans.add(root.val);
ans.addAll(inorderTraversal(root.right));
return ans;
}
}
```