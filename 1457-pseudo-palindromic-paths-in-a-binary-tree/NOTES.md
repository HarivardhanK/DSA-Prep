My Solution:
```
class Solution {
private int solve(TreeNode root, int[] ar) {
if(root == null) return 0;
if(root != null && root.left == null && root.right == null) {
ar[root.val]++;
int odds = 0;
for(int i = 0;i < 10; i++) {
if((ar[i]&1) == 1) odds++;
}
ar[root.val]--;
if(odds <= 1) return 1;
return 0;
}
ar[root.val]++;
int ans = solve(root.left, ar);
ans += solve(root.right, ar);
ar[root.val]--;
return ans;
}
public int pseudoPalindromicPaths (TreeNode root) {
return solve(root, new int[10]);
}
}
```