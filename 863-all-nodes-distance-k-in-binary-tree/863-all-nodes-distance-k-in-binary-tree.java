/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> childToParent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        childToParent.put(root, null);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                childToParent.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right!=null){
                childToParent.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> childToParent = new HashMap<>();
        markParents(root, childToParent);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        int dist=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist==k) break;
            dist++;
            visited.put(target, true);
            while(size-->0){
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    visited.put(node.left, true);
                    q.offer(node.left);
                }      
                if(node.right!=null && visited.get(node.right)==null){
                    visited.put(node.right, true);
                    q.offer(node.right);
                }
                if(childToParent.get(node)!=null && visited.get(childToParent.get(node))==null){
                    visited.put(childToParent.get(node), true);
                    q.offer(childToParent.get(node));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node =q.poll();
            ans.add(node.val);
        }
        return ans;
    }
}