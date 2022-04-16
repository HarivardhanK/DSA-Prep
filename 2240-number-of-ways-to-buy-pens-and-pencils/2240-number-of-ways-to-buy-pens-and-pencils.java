class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if(total<cost1 && total<cost2) return 1;
        if(cost1<cost2){
            int t = cost1;
            cost1=cost2;
            cost2=t;
        }

        long tways=0;
        while(total>=0){
            tways+=(total/cost2)+1;
            total-=cost1;
        }
        return tways;
    }
}