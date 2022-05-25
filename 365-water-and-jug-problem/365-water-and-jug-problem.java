class Solution {
    private int hcf(int j1, int j2){
        if(j1==0) return j2;
        return hcf(j2%j1, j1);
    }
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int j1 = Math.min(jug1Capacity,jug2Capacity);
        int j2 = Math.max(jug1Capacity,jug2Capacity);
        if((j1 + j2) < targetCapacity) return false;
        int hcf = hcf(j1, j2);
        return targetCapacity%hcf == 0;
    }
}