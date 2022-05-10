class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans = 0;
        for(int box[]:boxTypes){
            int took = ((truckSize<box[0])?truckSize:box[0]);
            ans +=  took* box[1];
            truckSize -= took;
        }
        return ans;
    }
}