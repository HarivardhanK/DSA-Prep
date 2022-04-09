class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(stk.empty() || asteroids[i]>=0) stk.push(asteroids[i]);
            else{
                while(!stk.empty() && stk.peek()>0 && stk.peek()<Math.abs(asteroids[i])) 
                    stk.pop();
                if(!stk.empty() && stk.peek()+asteroids[i]==0) stk.pop();
                else if(stk.empty() || stk.peek()<0) stk.push(asteroids[i]);
             }
        }
        
        int ans[] = new int[stk.size()];
        int i=stk.size()-1;
        while(!stk.empty()){
            ans[i--] = stk.pop();
        }
        return ans;
    }
}