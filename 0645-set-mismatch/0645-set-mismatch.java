class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length+1];
        for(int ele: nums) map[ele]++;
        
        int missing = map.length, dupli = map.length;
        for(int i =0 ; i < map.length; i++) {
            if(map[i] == 0) missing = i;
            else if(map[i] > 1) dupli = i;
        }
        return new int[]{dupli, missing};
    }
}