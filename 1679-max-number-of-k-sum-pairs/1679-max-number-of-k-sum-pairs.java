class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int ele:nums){
            if(map.containsKey(k-ele)){
                map.put(k-ele,map.get(k-ele)-1);
                if(map.get(k-ele)==0) map.remove(k-ele);
                ans++;
            }
            else{
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
        }
        return ans;
    }
}