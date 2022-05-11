class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies,1);
        
        //left to right
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                candies[i] = 1+candies[i-1];
            }
        }
        //further last index will not change
        int sum= candies[candies.length-1];

        //right to left
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],1 + candies[i+1]);
            }
            sum+=candies[i];
        }
        return sum;
    }
}