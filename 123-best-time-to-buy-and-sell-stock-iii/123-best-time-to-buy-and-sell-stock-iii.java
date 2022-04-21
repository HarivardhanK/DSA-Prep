class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ahead[] = new int[5];
        
        for(int i=n-1;i>=0;i--){
            int curr[] = new int[5];
            for(int j=3;j>=0;j--){
                if(j%2==0){
                    curr[j]=Math.max(-prices[i]+ahead[j+1],ahead[j]);
                }
                else{
                    curr[j]=Math.max(prices[i]+ahead[j+1],ahead[j]);
                }
            }
            ahead = curr;
        }
            
        return ahead[0];
    }
}