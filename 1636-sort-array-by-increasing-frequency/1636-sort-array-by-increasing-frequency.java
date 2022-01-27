class Pair{
    int num, freq;
    Pair(int num, int freq){
        this.num=num;
        this.freq=freq;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    if(b.freq - a.freq == 0)
                        return b.num - a.num;
                    return -(b.freq-a.freq); // reversed the frequency
                }
            }
        );
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int i=0;
        while(pq.size()>0){
            Pair p = pq.poll();
            int f = p.freq;
            while(f-->0) nums[i++] = p.num;
        }
        return nums;
    }
}