class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gassum=0, costsum=0;
        for(int i=0;i<gas.length;i++){
            gassum+=gas[i];
            costsum+=cost[i];
        }
        if(gassum<costsum) return -1;
        int tank = 0;
        int ind=0;
        for(int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                ind=i+1;
            }
        }
        return ind;
    }
}