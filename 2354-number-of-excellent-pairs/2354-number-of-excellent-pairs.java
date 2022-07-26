class Solution {
    public long countExcellentPairs(int[] nums, int k) {
//         Important Property: 
//         Number of setbits(AND(n1, n2)) + No. of setbits(OR(n1, n2)) = No. of setbits(n1, n2)
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < 32; i++) 
            map.put(i, new HashSet<>());
        
        for(int num: nums) {
            int currnum = num, setbits = 0;
            while(currnum > 0) {
                if((currnum&1) == 1) setbits++;
                currnum >>= 1;
            }
            map.get(setbits).add(num);   
        }
        
        long ans = 0;
        for(int i = 0; i <= 30; ++i) 
            for(int j = 0; j <= 30; ++j) 
                if(i + j >= k) 
                    ans += map.get(i).size() * map.get(j).size();
        
        return ans;
    }
}