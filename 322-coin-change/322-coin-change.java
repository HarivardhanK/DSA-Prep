class Solution {
    public int coinChange(int[] coins, int tar) {
        int n=coins.length;
        int prev[] = new int[tar+1];
        for(int i=0;i<=tar;i++)
            if(i%coins[0]==0) 
                prev[i] = i/coins[0];
            else
                prev[i]=(int)1e9;
        for(int i=1;i<n;i++){
            int curr[] = new int[tar+1];
            for(int k=0;k<=tar;k++){
                int nopick=prev[k];
                int pick = (int)1e9;
                if(coins[i]<=k) pick = 1+curr[k-coins[i]];
                curr[k] = Math.min(pick,nopick);
            }
            prev=curr;
        }
        return prev[tar]==1e9?-1:prev[tar];
    }
}