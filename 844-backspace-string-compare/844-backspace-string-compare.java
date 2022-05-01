class Solution {
    public String getString(String str){
        Stack<Character> stk = new Stack<>();
        for(char c:str.toCharArray()){
            if(c!='#'){
                stk.push(c);
            }
            else if(!stk.empty()){
                stk.pop();
            }
        }
        return String.valueOf(stk);
    }
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }
}