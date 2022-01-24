### Approach 1: recursive solution
**TC: O(NLogN) SC : O(N)
same used in binary tree but there inputs are preorder and inorder arrays
and here only preorder array so we need to create an inorder and sort
so, we follow another approach
```
class Solution {
TreeNode bstFromPreorder(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> mapIn){
if(ps>pe || is>ie) return null;
TreeNode root = new TreeNode(pre[ps]);
int inRoot = mapIn.get(root.val);
int inLeft = inRoot - is;
root.left = bstFromPreorder(pre, ps+1,ps+inLeft, in, is, inRoot-1, mapIn);
root.right = bstFromPreorder(pre, ps+inLeft+1, pe, in, inRoot+1, ie, mapIn);
return root;
}
public TreeNode bstFromPreorder(int[] preorder) {
int inorder[] = new int[preorder.length];
inorder =preorder.clone();
Arrays.sort(inorder);
Map<Integer, Integer> mapIn = new HashMap<>();
for(int i=0;i<inorder.length;i++) mapIn.put(inorder[i],i);
return bstFromPreorder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mapIn);
}
}
```