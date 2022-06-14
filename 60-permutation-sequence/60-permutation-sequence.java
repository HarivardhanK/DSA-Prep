class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            nums.add(i);
            fact *= i;
        }
        
        k -=1;
        fact /= n;
        String ans = "";
        
        while(nums.size() > 0) {
            ans += nums.get(k/fact);
            nums.remove(k/fact);
            
            if(nums.size() == 0) break;
            
            k %= fact;
            fact /= nums.size();
        }
        return ans;
    }
}