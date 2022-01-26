class Pair{
    int dis;
    int num;
    Pair(int dis, int num){
        this.dis=dis;
        this.num=num;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
        new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                // if both the keys are same then compare on the bases of their values
                if((b.dis - a.dis) == 0)
                    return b.num- a.num;
                return b.dis - a.dis;
            }
    });
        for(int i=0;i<arr.length;i++){
            pq.offer(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k) pq.poll();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().num);
        }
        Collections.sort(ans);
        return ans;
    }
}