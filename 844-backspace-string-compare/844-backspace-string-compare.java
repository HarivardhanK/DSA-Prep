class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){
            if(c!='#'){
                stk.push(c);
            }
            else if(!stk.empty()){
                stk.pop();
            }
        }
        s="";
        while(!stk.isEmpty()) s=stk.pop()+s;
        for(char c:t.toCharArray()){
            if(c!='#'){
                stk.push(c);
            }
            else if(!stk.empty()){
                stk.pop();
            }
        }
        t="";
        while(!stk.isEmpty()) t=stk.pop()+t;
        return s.equals(t);
    }
}