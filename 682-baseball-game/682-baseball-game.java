class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        for(String op:ops){
            if(op.equals("C")){
                stk.pop();
            }
            else if(op.equals("D")){
                stk.push(stk.peek()*2);
            }
            else if(op.equals("+")){
                int n1 = stk.pop();
                int n2 = stk.pop();
                stk.push(n2);
                stk.push(n1);
                stk.push(n1+n2);
            }
            else{
                stk.push(Integer.parseInt(op));
            }
        }
        int sum=0; 
        while(!stk.empty()) sum+=stk.pop();
        return sum;
    }
}