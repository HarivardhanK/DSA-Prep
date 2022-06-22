[solution](https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/531822/Java-Post-Order-Traverse-with-Comment-Clean-code)
​
```
simple rule is that
if largest node on left subtree is less than root
if smallest node on right subtree is greater then root then it is a BST
```
Solution:
```
// which stores the lowerbound, upperbound and maxsum
class NodeValue {
int minNode, maxNode, maxSize;
NodeValue(int min, int max, int size) {
minNode = min;
maxNode = max;
maxSize = size;
}
}
class Solution {
// global variables
int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
int maxsum = 0;
private NodeValue solve(TreeNode root) {
if(root == null)
return new NodeValue(MAX, MIN, 0);
//post order traversal
NodeValue left = solve(root.left);