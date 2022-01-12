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
class Solution {
public List<Integer> preorderTraversal(TreeNode root) {
if(root==null)
return new ArrayList<Integer>();
ArrayList<Integer> ans = new ArrayList<>();
Stack<TreeNode> s = new Stack<>();
s.push(root);
while(!s.isEmpty()){
int size = s.size();
TreeNode temp;
while(size-->0){
temp = s.pop();
if(temp.right!=null)
s.push(temp.right);
if(temp.left!=null)
s.push(temp.left);
ans.add(temp.val);
}
}
return ans;
}
}
​