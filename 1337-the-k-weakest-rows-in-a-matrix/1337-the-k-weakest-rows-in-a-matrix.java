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
        int count=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair p, Pair q){
                    if(p.soldiers==q.soldiers) return -1*(p.index-q.index);
                    return -1*(p.soldiers-q.soldiers);
                }
            }
        );
        for(int i=0;i<mat.length;i++){
            count=0;
            for(int j=0;j<mat[i].length && mat[i][j]==1;j++){
                count+=mat[i][j];
            }
            pq.offer(new Pair(count,i));
            if(pq.size()>k) pq.poll();
        }
        int ans[] = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll().index;
        }
        return ans;
    }
}