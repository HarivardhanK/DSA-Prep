class MyHashMap {
    int key_arr[]=new int[1000];
    int value_arr[] = new int[1000];
    public MyHashMap() {
        Arrays.fill(key_arr,-1);
    }
    
    public void put(int key, int value) {
        if(key_arr.length<key)
            extend(key);
        key_arr[key] = key;
        value_arr[key] = value;
    }
    
    public int get(int key) {
        if(key<key_arr.length && key_arr[key]!=-1) 
            return value_arr[key];
        return -1;
    }
    
    public void remove(int key) {
        if(key<key_arr.length && key_arr[key]!=-1){
            key_arr[key]=-1;
            value_arr[key]=-1;
        }
    }
    private void extend(int key){
        int temp[]=key_arr;
        int i;
        int n=key_arr.length;
        key_arr = new int[key+2];
        for(i=0;i<temp.length;i++)
            key_arr[i] = temp[i];
        temp = new int[key_arr.length-temp.length+1];
        Arrays.fill(temp,-1);
        for(;i<key_arr.length;i++)
            key_arr[i] = temp[i-n];
        value_arr = Arrays.copyOf(value_arr,key+2);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */