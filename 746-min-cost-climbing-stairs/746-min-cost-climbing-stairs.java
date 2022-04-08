class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1=0,prev2=0,curr=0;
        for(int i=0;i<cost.length;i++){
            curr = cost[i]+Math.min(prev1,prev2);
            prev2=prev1;
            prev1=curr;
        }
        return Math.min(prev1,prev2);
    }
}