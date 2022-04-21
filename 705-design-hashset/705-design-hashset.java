class MyHashSet {
    boolean bool_arr[] = new boolean[200];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(bool_arr.length<=key)
            extendArr(key);
        bool_arr[key] = true;
    }
    
    public void remove(int key) {
        if(key<bool_arr.length) bool_arr[key] = false;
    }
    
    public boolean contains(int key) {
        if(key<bool_arr.length)
            return bool_arr[key];
        return false;
    }
    private void extendArr(int key){
        bool_arr = Arrays.copyOf(bool_arr,key+2);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */