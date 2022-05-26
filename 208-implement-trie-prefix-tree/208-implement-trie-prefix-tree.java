class Node{
    Node[] link = new Node[26];
    boolean end = false;
    Node(){}
    
    boolean containsChar(char c){
        return (link[c - 'a']!=null);
    }
    
    Node get(char c){
        return (link[c - 'a']);
    }
    
    void put(char c, Node node){
        link[c - 'a'] = node;
    }
    
    void setEnd(){
        end = true;
    }
    
    boolean isEnd(){
        return end;
    } 
    
}
class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsChar(ch))
                node.put(ch,new Node());
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsChar(ch))
                return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch: prefix.toCharArray()){
            if(!node.containsChar(ch))
                return false;
            node = node.get(ch);
        }
        return true;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */