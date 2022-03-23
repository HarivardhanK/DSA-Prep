class MinStack {
    Stack<Integer> stk;
    int minnum;
    public MinStack() {
        stk=new Stack<>();
        minnum=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= minnum){
            stk.push(minnum);
            minnum=val;
        }
        stk.push(val);
    }
    
    public void pop() {
        if(stk.pop()==minnum)
            minnum=stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minnum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */