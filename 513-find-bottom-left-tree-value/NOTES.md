Breadth first search with O(N) :
​
```
class Solution {
public int findBottomLeftValue(TreeNode root) {
Queue<TreeNode> q = new LinkedList<>();
q.offer(root);
int leftmostnode=root.val;
while(q.size()>0){
int size=q.size();
leftmostnode=q.peek().val;
while(size-->0){
TreeNode node = q.poll();
if(node.left!=null) q.offer(node.left);
if(node.right!=null) q.offer(node.right);
}
}
return leftmostnode;
}
}
```