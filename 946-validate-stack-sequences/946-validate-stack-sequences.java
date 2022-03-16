class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i=0,j=0;
        while(i<pushed.length){
            while(!stk.isEmpty() && popped[j]==stk.peek()){
                stk.pop();
                j++;
            }
            if(pushed[i]!=popped[j]) stk.push(pushed[i]);
            else j++;
            i++;
        }
        while(j<popped.length && !stk.isEmpty() && popped[j]==stk.peek()){
            stk.pop();
            j++;
        }
        if(j<popped.length || !stk.isEmpty()) return false;
        return true;
    }
}