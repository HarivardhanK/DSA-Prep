class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stk.push(i);
            }
            else{
                if(stk.peek()!=-1 && s.charAt(stk.peek())!=')'){
                    stk.pop();
                    max = Math.max(max, i - stk.peek());
                }
                else{
                    stk.push(i);
                }
            }
        }
        return max;
    }
} 