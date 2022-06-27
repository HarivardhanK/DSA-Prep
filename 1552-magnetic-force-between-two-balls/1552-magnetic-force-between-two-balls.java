class Solution {
    private boolean ispossible(int mid, int[] position, int m) {
        int ballsCount = 1;
        for(int i = 0,j = 0; j < position.length; j++) {
            if(position[j] - position[i] >= mid) {
                ballsCount++;
                if(ballsCount == m) return true;
                i=j;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n - 1] - position[0];
        int ans = 1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(ispossible(mid, position, m)) {
                ans = mid;
                low = mid + 1; 
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}