class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder() {
        //left side of the array
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //right side
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int lsize = maxHeap.size();
        int rsize = minHeap.size();
        if(lsize == 0) {
            maxHeap.offer(num);
        }
        else if(lsize == rsize) {
            if(num < minHeap.peek()) {
                maxHeap.offer(num);
            }
            else{
                int temp = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(temp);
            }
        }
        else {
            if(rsize == 0) {
                if(num > maxHeap.peek()) {
                    minHeap.offer(num);
                }
                else{
                    int temp = maxHeap.poll();
                    minHeap.offer(temp);
                    maxHeap.offer(num);
                }
            }
            else if(minHeap.peek() <= num) 
                minHeap.offer(num);
            else{
                if(num > maxHeap.peek()) {
                    minHeap.offer(num);
                }
                else{
                    int temp = maxHeap.poll();
                    minHeap.offer(temp);
                    maxHeap.offer(num);
                }
            }
        }
    }
    
    public double findMedian() {
        System.out.println(minHeap.size() + " "+maxHeap.size());
        if((minHeap.size() + maxHeap.size()) % 2 == 0) 
            return (double)(minHeap.peek() + maxHeap.peek()) /2.0;
        return (double)maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */