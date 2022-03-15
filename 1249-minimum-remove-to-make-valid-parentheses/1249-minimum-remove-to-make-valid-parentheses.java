class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stk.push(i);
            }
            if(s.charAt(i)==')'){
                if(!stk.isEmpty()) stk.pop();
                else str.setCharAt(i,'*');
            }
        }
        while(!stk.isEmpty()) str.setCharAt(stk.pop(),'*');
        return str.toString().replaceAll("\\*","");
    }
}