class Solution {
    int[] parent;
    int[] rank;
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(rank[px] > rank[py]) {
            parent[py] = px;
        }
        else if(rank[px] < rank[py]) {
            parent[px] = py;
        }
        else {
            rank[py]++;
            parent[px] = py;
        }
    }
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        //intiailising the parent and rank arr
        for(int i = 0;i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(String eq: equations) {
            if(eq.charAt(1) == '!') continue;
            
            union(eq.charAt(0)-'a', eq.charAt(3)-'a');
        }
        
        for(String eq: equations) {
            if(eq.charAt(1) != '!') continue;
            
            if(find(eq.charAt(0)-'a') == find(eq.charAt(3)-'a')) 
                return false;
        }
        return true;
        
    }
}