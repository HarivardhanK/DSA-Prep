class MyCircularQueue {
    int[] queue;
    int front, rear;
    int count;
    public MyCircularQueue(int k) {
        queue = new int[k];
        front =-1;
        rear=-1;
        count=0;
    }
    
    public boolean enQueue(int value) {
        if(count==queue.length)
            return false;
        if(front==-1){
            front=0;
        }
        queue[(++rear)%queue.length] =value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0)
            return false;
        front++;
        count--;
        return true;
    }
    
    public int Front() {
        return count!=0?queue[front%queue.length]:-1;
    }
    
    public int Rear() {
        return count!=0?queue[rear%queue.length]:-1;
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */