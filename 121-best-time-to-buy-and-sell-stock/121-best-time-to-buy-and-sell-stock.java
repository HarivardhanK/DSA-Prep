class Solution {
    public int maxProfit(int[] prices) {
        int minonleft=prices[0],profit=0;
        for(int price:prices){
            int day=price-minonleft;
            profit=Math.max(profit,day);
            minonleft=Math.min(minonleft,price);
        }
        return profit;
    }
}