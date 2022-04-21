class Solution {
    public int maxProfit(int[] prices) {
        //sell-0, buy-1 , cooldown - 2 
        int n=prices.length;
        int []ahead = new int[2];
        int [] ahead1 = new int[2];
        
        for(int ind=n-1;ind>=0;ind--){
            int []curr = new int[2];
            for(int j=0;j<=1;j++){
                if(j==1){
                    curr[j]=Math.max(-prices[ind]+ahead[0],ahead[1]);
                }
                else{
                    int smallprofit=0;
                    if(ind+2<=n) smallprofit+=ahead1[1];
                    curr[j]= Math.max(prices[ind]+smallprofit,ahead[0]);
                }
            }
            ahead1=ahead;
            ahead=curr;
        }
        return ahead[1];   
    }
}