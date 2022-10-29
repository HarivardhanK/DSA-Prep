class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] time = new int[n][2];
        for(int i = 0;i < n; i++) {
            time[i][0] = plantTime[i];
            time[i][1] = growTime[i];
        }
        Arrays.sort(time, (a,b)-> b[1]-a[1]);
        int minbloom = 0, currPlantTime = 0;
        
        for(int i = 0;i < n; i++) {
            minbloom = Math.max(minbloom, currPlantTime+time[i][0]+time[i][1]);
            currPlantTime += time[i][0];
        }
        return minbloom;
    }
}