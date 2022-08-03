class MyCalendar {
    List<int[]> arr;
    public MyCalendar() {
        arr = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] node: arr) {
            // if((node[0] <= start && start < node[1]) || (node[0] < end && end <= node[1]))
            if(node[0] < end && start < node[1])
                return false;
        }
        arr.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 [null,true,true,false,false,true,false,true,true,true,false]
 */