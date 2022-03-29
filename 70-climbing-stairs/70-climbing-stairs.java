class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        //with out an extra space
        int curr=0,prev1=1,prev2=1;
        for(int i=1;i<n;i++){
            curr=prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return curr;
        
    }
}
