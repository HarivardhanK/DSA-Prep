class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stk.push(-1);
            }
            else{
                if(stk.peek()==-1){
                    stk.pop();
                    stk.push(1);
                }
                else{
                    int A = 0;
                    while(!stk.isEmpty() && stk.peek()!=-1){
                        A+=stk.pop();
                    }
                    stk.pop();
                    A*=2;
                    stk.push(A);
                }
            }
        }
        int A = 0;
        while(!stk.isEmpty() && stk.peek()!=-1){
            A+=stk.pop();
        }
        A*=2;
        return A/2;
    }
}