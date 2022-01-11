# Brute Force with extra space :
```
class Solution {
ArrayList<String> ans;
private void sumStrings(TreeNode root, String p){
if(root.right==null && root.left==null){
ans.add(p+root.val);
return;
}
if(root.right!=null)
sumStrings(root.right,p+root.val);
if(root.left!=null)
sumStrings(root.left, p+root.val);
}
public int sumNumbers(TreeNode root) {
ans= new ArrayList<>();
String p = "";
sumStrings(root, p);
int sum=0;
for(String s: ans){
sum+=Integer.parseInt(s);
}
return sum;
}
}
```