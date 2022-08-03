class MyCalendar {
    // pair of (start, end) 
    //used a treemap because it is a balanced, red-black tree and insertion and searching is O(logn)
    //which optimises our solution
    TreeMap<Integer, Integer> treemap; 
    public MyCalendar() {
        treemap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        //condition for start
        //if start < lower entry end
        if(treemap.floorEntry(start) != null && start < treemap.floorEntry(start).getValue()) 
            return false;
        
        //condtion for end
        //if Higher entry start < end
        if(treemap.ceilingEntry(start) != null && treemap.ceilingEntry(start).getKey() < end)
            return false;
        
        treemap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */