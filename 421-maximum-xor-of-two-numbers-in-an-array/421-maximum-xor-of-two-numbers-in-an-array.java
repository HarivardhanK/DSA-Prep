class Node{
    Node link[] = new Node[2];
    
    boolean containsBit(int i){
        return (link[i]!=null);
    }
    
    Node get(int i){
        return link[i];
    }
    
    void put(int i, Node node){
        link[i] = node;
    }
}
class Trie{
    private Node root;
    Trie(){
        root =  new Node();
    }
    void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(!node.containsBit(bit))
                node.put(bit,new Node());
            node = node.get(bit);
        }
    }
    int maxXor(int num){
        Node node = root;
        int max = 0;
        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(node.containsBit(1 - bit)){
                max += Math.pow(2,i);
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return max;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int ele: nums)
            trie.insert(ele);
        
        int max = -1;
        for(int ele: nums){
            max = Math.max(max, trie.maxXor(ele));
        }
        return max;
    }
}