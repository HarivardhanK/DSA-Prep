**Recursive solution:**
simple and crisp solution
runtime :1ms
​
```
class Solution {
public void rightsiderec(TreeNode node, List<Integer> ans, int level){
if(node==null) return ;
if(level==ans.size()) ans.add(node.val);
rightsiderec(node.right,ans,level+1);
rightsiderec(node.left,ans,level+1);
}
public List<Integer> rightSideView(TreeNode root) {
List<Integer> ans = new ArrayList<>();
rightsiderec(root, ans, 0);
return ans;
}
}
```
​
**# Iterative solution:**
​
runtime :3ms
```
class Pair{
TreeNode node;