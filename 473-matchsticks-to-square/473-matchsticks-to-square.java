class Solution {
    private boolean solve(int[] ms, int ind, int[] sums, int target) {
        if(ind == ms.length) 
            return (sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target);
        
        for(int i = 0; i < 4; i++) {
            if(sums[i] + ms[ind] > target) continue;
            
            sums[i] += ms[ind];
            if(solve(ms, ind + 1, sums, target)) return true;
            sums[i] -= ms[ind];
        }
        
        return false;
    }
    private void reverse(int[] arr) {
        int s = 0, e = arr.length - 1, temp;
        while(s < e) {
            temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) return false; 
        int sum = 0;
        for(int ele: matchsticks) sum += ele;
        if(sum % 4 != 0 ) return false;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return solve(matchsticks, 0, new int[4], sum/4);
   }
}