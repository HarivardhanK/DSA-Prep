class StockSpanner {
    Stack<Integer> stk;
    ArrayList<Integer> arr;
    public StockSpanner() {
        stk = new Stack<>();
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
        while(stk.size()>0 && arr.get(stk.peek())<=price) stk.pop();
        arr.add(price);
        int ans =  (stk.size()>0)?arr.size()-stk.peek()-1:1;
        if(stk.size()==0 && arr.size()>1) ans = arr.size();
        stk.push(arr.size()-1);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */