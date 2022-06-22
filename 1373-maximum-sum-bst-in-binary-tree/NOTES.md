int max = Math.max(right.maxNode, Math.max(root.val, left.maxNode));
int maxi = 0;
if(left.maxSize >= 0 && right.maxSize >= 0 ){
maxi = left.maxSize + right.maxSize + root.val;
}
else if(left.maxSize > 0) {
maxi += left.maxSize;
}
else if(right.maxSize > 0) {
maxi += right.maxSize;
}
return new NodeValue(min, max, maxi);
}
return new NodeValue(MIN, MAX, Math.max(left.maxSize, right.maxSize));
}
/*
simple rule is that
if largest node on left subtree is less than root
if smallest node on right subtree is greater then root then it is a BST
*/
public int maxSumBST(TreeNode root) {
// int max =  solve(root).maxSize;
// return Math.max(max, 0);
solve(root).maxSize;
return maxsum;
}
}