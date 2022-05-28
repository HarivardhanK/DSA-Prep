class Pair{
    int point;
    ArrayList<Integer> travellers;
    Pair(int point, ArrayList<Integer> travellers){
        this.point = point;
        this.travellers = travellers;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Batch the similar entry and exit
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] trip: trips){
            //pick up
            map.putIfAbsent(trip[1], new ArrayList<>());
            map.get(trip[1]).add(trip[0]);       
            //drop off
            map.putIfAbsent(trip[2], new ArrayList<>());
            map.get(trip[2]).add(-trip[0]);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a,b)-> a.point - b.point
        );
        
        for(Map.Entry<Integer, ArrayList<Integer>> en: map.entrySet()) {
            minHeap.offer(new Pair(en.getKey(), en.getValue()));
        }
        
        int currCap = 0;
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            for(int traveller: p.travellers){
                currCap += traveller;
            }
            if(currCap > capacity)
                return false;
        }
        return true;
    }
}