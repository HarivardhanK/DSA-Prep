class Solution {
    public int minCost(String colors, int[] neededTime) {
        // int n = neededTime.length, currmax =-1, ans = 0;
        // int[] presum = new int[n];
        // if(n > 1 && colors.charAt(0) == colors.charAt(1)) {
        //     currmax = neededTime[0];
        //     presum[0] = currmax;
        // }
        
        
        int n = neededTime.length;
        int currmax = 0, currsum = 0, mintime = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0 && i+1 < n && colors.charAt(i) == colors.charAt(i+1) && colors.charAt(i-1) != colors.charAt(i)) {
                mintime += currsum - currmax;
                currsum = 0;
                currmax = 0;
            }
            if(i>0 && colors.charAt(i)==colors.charAt(i-1)) {
                currmax = Math.max(currmax, neededTime[i]);
                currsum += neededTime[i];
            }
            else if(i+1<n && colors.charAt(i)==colors.charAt(i+1)) {
                currmax = Math.max(currmax, neededTime[i]);
                currsum += neededTime[i];
            }
            else {
                mintime += currsum - currmax;
                currsum = 0;
                currmax = 0;
            }
        }
        mintime += currsum - currmax;
        
        return mintime;
    }
}