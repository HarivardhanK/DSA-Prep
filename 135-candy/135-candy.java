class Solution {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        
        for(int i = 1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i-1] + 1;
            }
        }
        for(int j = ratings.length -2; j >= 0; j--) {
            if(ratings[j] > ratings[j + 1]) {
                ans[j] = Math.max(ans[j], 1 + ans[j + 1]);
            }
        }
        int sum = 0;
        for(int ele: ans) {
            sum += ele;
        }
        return sum;
    }
}