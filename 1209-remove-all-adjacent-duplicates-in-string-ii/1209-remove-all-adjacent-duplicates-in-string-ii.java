class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charstk = new Stack<>();
        Stack<Integer> countstk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(charstk.isEmpty() || charstk.peek() != s.charAt(i)){
                charstk.push(s.charAt(i));
                countstk.push(1);
            }
            else if(charstk.peek() == s.charAt(i) && countstk.peek()+1<k){
                countstk.push(countstk.pop()+1);
            }
            else{
                countstk.pop();
                charstk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!charstk.isEmpty()){
            char c = charstk.pop();
            int count = countstk.pop();
            while(count-->0){
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}