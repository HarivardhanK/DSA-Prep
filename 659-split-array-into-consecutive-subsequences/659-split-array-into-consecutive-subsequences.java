class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> availMap = new HashMap<>();
        Map<Integer, Integer> vacancyMap = new HashMap<>();
        
        for(int ele: nums) 
            availMap.put(ele, availMap.getOrDefault(ele, 0) + 1);
        
        for(int ele: nums) {
            if(availMap.get(ele) <= 0) continue;
            
            if(vacancyMap.getOrDefault(ele, 0) > 0) {
                availMap.put(ele, availMap.get(ele) - 1);
                vacancyMap.put(ele, vacancyMap.get(ele) - 1);
                vacancyMap.put(ele + 1, vacancyMap.getOrDefault(ele + 1, 0)  + 1);
            }
            else if(availMap.getOrDefault(ele + 1, 0) > 0 && 
                   availMap.getOrDefault(ele + 2, 0) > 0) {
                availMap.put(ele, availMap.get(ele) - 1);
                availMap.put(ele + 1, availMap.get(ele + 1) - 1);
                availMap.put(ele + 2, availMap.get(ele + 2) - 1);
                vacancyMap.put(ele + 3, vacancyMap.getOrDefault(ele  + 3, 0) + 1);
            }
            else return false;
        }
            return true;
    }
}