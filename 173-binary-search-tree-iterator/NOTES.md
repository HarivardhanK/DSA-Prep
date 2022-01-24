### Approach 1 : with TC of O(N) and SC of O(N)
​
```
class BSTIterator {
ArrayList<Integer> bst = new ArrayList<>();
int i=0;
private void bstfill(TreeNode root){
if(root==null) return;
bstfill(root.left);
bst.add(root.val);
bstfill(root.right);
}
public BSTIterator(TreeNode root) {
bstfill(root);
}
public int next() {
if(i>=bst.size()) return -1;
return bst.get(i++);
}
public boolean hasNext() {
return i<bst.size();
}
}
```