class Solution {
    public int minCostToMoveChips(int[] position) {
        int even_count = 0, odd_count = 0;
        for(int ele: position){
            if(ele%2 == 0) even_count++;
            else odd_count++;
        }
        return Math.min(even_count, odd_count);
    }
}