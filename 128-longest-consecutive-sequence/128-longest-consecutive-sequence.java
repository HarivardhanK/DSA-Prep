class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int ele: nums) 
            set.add(ele);
        
        int longestcon = 0;
        for(int ele: nums) {
            if(!set.contains(ele - 1)) {
                int count = 1;
                while(set.contains(ele + 1)){
                    count++;
                    ele++;
                }
                longestcon = Math.max(longestcon, count);
            }
        }
        return longestcon;
    }
}