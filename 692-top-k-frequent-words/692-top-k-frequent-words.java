class Pair{
    int freq;
    String s;
    Pair(String s, int freq){
        this.s=s;
        this.freq=freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        //hashing elements with word and frequency
        for(String word: words) map.put(word,map.getOrDefault(word,0)+1);
        
        //declaring a priorityqueue (max---min) so we use minheap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    if(a.freq==b.freq) 
                        return b.s.compareTo(a.s);
                    return -(b.freq-a.freq);
                }
            }
        );
        for(Map.Entry<String, Integer> ent:map.entrySet()){
            pq.offer(new Pair(ent.getKey(),ent.getValue()));
            if(pq.size()>k) pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(pq.size()>0)
            ans.add(0,pq.poll().s);
        return ans;
    }
}