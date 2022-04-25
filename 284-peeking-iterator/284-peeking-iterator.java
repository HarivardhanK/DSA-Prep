// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    List<Integer> iterarr = new ArrayList<>();
    int i=0;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while(iterator.hasNext())
            iterarr.add(iterator.next());
        
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return iterarr.get(i);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return iterarr.get(i++);
	}
	
	@Override
	public boolean hasNext() {
	    return i<iterarr.size();
	}
}