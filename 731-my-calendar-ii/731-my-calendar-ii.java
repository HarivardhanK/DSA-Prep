class MyCalendarTwo {
    List<int[]> bookings, doublebookings;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doublebookings = new ArrayList<>();
    }
    private boolean isOverlap(int s1, int e1, int s2, int e2) {
        return Math.max(s1, s2) < Math.min(e1, e2);
    }
    public boolean book(int start, int end) {
        
        // we check for the triple booking by comparing the overlappings in the double bookings list
        for(int[] doublebooking: doublebookings) {
            int dstart = doublebooking[0], dend = doublebooking[1];
            if(isOverlap(dstart, dend, start, end))
                return false;
        }
        
        // now we add all the double bookings to our double bookings list
        for(int[] booking: bookings) {
            int s = booking[0], e = booking[1];
            if(isOverlap(s, e, start, end)) 
                doublebookings.add(new int[]{Math.max(s, start), Math.min(e, end)});
        }
        
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */