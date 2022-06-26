class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int arrsum = 0;
        for(int cardpoint: cardPoints) {
            arrsum += cardpoint;
        }
        if(k == cardPoints.length) return arrsum;
        
        int currsum = 0, minsum = (int)1e9;
        int windowsize = cardPoints.length - k;
        
        for(int i=0,j=0; j < cardPoints.length;j++) {
            currsum += cardPoints[j];
            if( j - i + 1 >= windowsize) {
                minsum = Math.min(currsum, minsum);
                currsum -= cardPoints[i++];
            }
        }
        return arrsum - minsum;
    }
}