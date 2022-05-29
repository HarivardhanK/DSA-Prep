class Node {
    Node nodes[];
    
    Node(){
        nodes = new Node[2];
    }
    
    boolean containsBit(int i){
        return (nodes[i] != null);
    }
    
    Node get(int i){
        return nodes[i];
    }
    
    void put(int i, Node node){
        nodes[i] = node;
    }
}
class Trie {
    private Node root;
    
    Trie(){
        root = new Node();
    }
    
    void insert(int num) {
        Node node = root;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            // System.out.println(bit);
            if(!node.containsBit(bit))
                node.put(bit, new Node());
            node = node.get(bit);
        }
    }
    
    int maxXor(int num){
        Node node = root;
        int max = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.containsBit(1 - bit)) {
                max += Math.pow(2, i);
                node = node.get(1 - bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return max;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[][] quer = new int[queries.length][3];
        for(int i = 0;i<queries.length; i++){
            quer[i][0] = queries[i][0];
            quer[i][1] = queries[i][1];
            quer[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(quer, (a, b) -> a[1] - b[1]);

        Trie trie = new Trie();
        int[] ans = new int[queries.length];
        int ind = 0;
        for(int[] query: quer) {
            while(ind < nums.length && nums[ind] <= query[1]){
                trie.insert(nums[ind]);
                ind++;
            }
            if(ind == 0)
                ans[query[2]] = -1;
            else
                ans[query[2]] = trie.maxXor(query[0]);
        }
        return ans;
    }
}