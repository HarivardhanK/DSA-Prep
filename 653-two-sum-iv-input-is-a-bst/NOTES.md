#### didn't work dono why?
​
```
class Solution {
private TreeNode next(TreeNode root, Stack<TreeNode> s){
while(root!=null){
s.push(root);
root=root.left;
}
if(!s.isEmpty())
root = s.pop();
return root;
}
private TreeNode before(TreeNode root, Stack<TreeNode> s){
while(root!=null){
s.push(root);
root=root.right;
}
if(!s.isEmpty())
root = s.pop();
return root;
}
public boolean findTarget(TreeNode root, int k) {
Stack<TreeNode> nextS = new Stack<>();
Stack<TreeNode> beforeS = new Stack<>();
TreeNode nextNode = next(root, nextS);
TreeNode beforeNode = before(root, beforeS);
int nextele =nextNode.val, beforeele=beforeNode.val;
while(nextele<beforeele){
if(nextele!=beforeele && nextele+beforeele==k) return true;
if((nextele+beforeele)<k){
nextNode = next(nextNode.right,nextS);
nextele=(nextNode!=null)?nextNode.val:Integer.MIN_VALUE;
}
else{
beforeNode = next(nextNode.left, beforeS);
beforeele=(beforeNode!=null)?beforeNode.val:Integer.MAX_VALUE;
}
if(nextele+beforeele==k) return true;
if(nextS.isEmpty() || beforeS.isEmpty()) break;
}
return false;
}
}
```