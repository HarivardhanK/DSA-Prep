class StockSpanner {
    Stack<Integer[]> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    public int next(int price) {
        int res=1;
        while(stk.size()>0 && stk.peek()[0]<=price) 
            res+=stk.pop()[1];
        stk.push(new Integer[]{price,res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */