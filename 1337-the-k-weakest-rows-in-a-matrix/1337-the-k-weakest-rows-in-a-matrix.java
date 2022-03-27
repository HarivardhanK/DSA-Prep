class Pair{
    int soldiers;
    int index;
    Pair(int s, int i){
        soldiers=s;
        index=i;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //Max Heap(weakest -> strongest)
        PriorityQueue<Pair> pq = new PriorityQueue<>((p,q)->
            (p.soldiers==q.soldiers)      //if soldiers in pth and qth row are equal
                ?(q.index-p.index)        //then we go for min of two index
                :(q.soldiers-p.soldiers));//else we take min of two soldiers
        for(int i=0;i<mat.length;i++){
            int low=0,high=mat[i].length;
            //Binary search to find the last soldiers in a row
            while(low<high){
                int mid=low+(high-low)/2;
                if(mat[i][mid]!=0) low=mid+1;
                else high=mid;
            }
            pq.offer(new Pair(low,i));
            if(pq.size()>k) pq.poll();
        }
        int ans[] = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll().index;
        }
        return ans;
    }
}