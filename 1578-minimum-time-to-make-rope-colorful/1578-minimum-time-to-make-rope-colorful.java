class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int currmax = 0, mintime = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)) 
                currmax = 0;
            
            mintime += Math.min(currmax, neededTime[i]);
            currmax = Math.max(currmax, neededTime[i]);
        }
        return mintime;
    }
}