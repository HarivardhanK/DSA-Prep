class Pair{
    int dist;
    int []point;
    Pair(int dist, int []point){
        this.dist=dist;
        this.point=point;
    }
}
class Solution {
    public int calculateDis(int a , int b){
        return a*a + b*b;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    if(a.dist==b.dist)
                        return a.dist;
                    return b.dist - a.dist;
                }
            }
        );
        for(int i=0;i<points.length;i++){
            int dist = calculateDis(points[i][0],points[i][1]);
            pq.offer(new Pair(dist, points[i]));
            if(pq.size()>k) pq.poll();
        }
        int [][]ans = new int[k][2];
        int i=0;
        while(pq.size()>0){
            ans[i++] = pq.poll().point;
        }
        return ans;
    }
}