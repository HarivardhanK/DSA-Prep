class Solution {
    public int change(int amount, int[] coins) {
        int []prev = new int[amount+1];
        //base condition:
        for(int i=0;i<=amount;i++)
            if(i%coins[0]==0) prev[i]=1;
            else prev[i]=0;
        //nested loops:
        for(int i=1;i<coins.length;i++){
            int []curr = new int[amount+1];
            for(int tar=0;tar<=amount;tar++){
                int nonpick = prev[tar];
                int pick=0;
                if(coins[i]<=tar)
                    pick=curr[tar-coins[i]];
                curr[tar]=pick+nonpick;
            }
            prev=curr;
        }
        return prev[amount];
    }
}