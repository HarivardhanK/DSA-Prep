# Iterative Solution:
while converting the recursive to iterative we need an explicit stack
​
# Recursive Solution:
​
```
class Solution {
public List<Integer> postorderTraversal(TreeNode root) {
if(root == null)
return new ArrayList<Integer>();
ArrayList<Integer> ans = new ArrayList<>();
ans.addAll(postorderTraversal(root.left));
ans.addAll(postorderTraversal(root.right));
ans.add(root.val);
return ans;
}
}
```