class CustomStack {
    int []inc;
    int n;
    Stack<Integer> s;
    public CustomStack(int maxSize) {
        inc = new int[maxSize];
        n=maxSize;
        s= new Stack<>();
    }
    
    public void push(int x) {
        if(s.size()<n)
            s.push(x);
    }
    
    public int pop() {
        int i=s.size()-1;
        if(i<0)
            return -1;
        if(i>0)
            inc[i-1]+=inc[i];
        int res = s.pop() + inc[i];
        inc[i]=0;
        return res;
    }
    
    public void increment(int k, int val) {
        int i=Math.min(k,s.size())-1;
        if(i>=0)
            inc[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */