class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty() && stk.peek()==s.charAt(i)) stk.pop();
            else stk.push(s.charAt(i));
        }
        // s="";
        StringBuilder ans = new StringBuilder(); 
        while(!stk.isEmpty())
            ans.append(stk.pop());
        return ans.reverse().toString();
    }
}