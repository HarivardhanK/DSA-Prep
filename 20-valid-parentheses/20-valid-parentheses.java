class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
                stk.add(s.charAt(i));
            else {
                if(stk.isEmpty()) return false;
                char c = stk.pop();
                if(c=='[' &&  s.charAt(i)!=']') return false;
                else if(c=='{' &&  s.charAt(i)!='}') return false;
                else if(c=='(' &&  s.charAt(i)!=')') return false;
            }
            i++;
        }
        if(!stk.isEmpty()) return false;
        return true;
    }
}