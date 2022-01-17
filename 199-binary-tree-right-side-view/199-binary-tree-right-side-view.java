/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node,int level){
        this.node = node;
        this.level=level;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int level= p.level;
            map.put(level,node.val);
            if(node.left!=null) q.offer(new Pair(node.left, level+1));
            if(node.right!=null) q.offer(new Pair(node.right,level+1));
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()) ans.add(m.getValue());
        return ans;
    }
}