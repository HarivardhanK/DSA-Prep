class Solution {
    public int longestConsecutive(int[] nums) {
        // brute force is to sort the entire array and check for the consecutive elements 
        // which has the time complexity of O(NlogN) and O(1)
        
        // optimised solution: 
        // use a hash for searching the next consecutive element in the array
        // we need a set for storing all the elements of an array
        // we don't care about the duplicates 
        
        Set<Integer> set = new HashSet<>();
        for(int ele: nums) {
            set.add(ele);
        }
        int max = 0;
        
        for(int ele: nums) {
            if(!set.contains(ele - 1)) {
                int curr = 1;
                while(set.contains(ele + 1)) {
                    curr++;
                    ele++;
                }
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}