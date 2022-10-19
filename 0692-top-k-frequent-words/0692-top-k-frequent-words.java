class Solution {
    class Pair{
        String word;
        int freq;
        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0)+1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->(a.freq==b.freq)?b.word.compareTo(a.word):a.freq-b.freq);
        for(Map.Entry<String, Integer> en: map.entrySet()) {
            pq.offer(new Pair(en.getKey(), en.getValue()));
            if(pq.size() > k) pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(k--> 0) ans.add(pq.poll().word);
        Collections.reverse(ans);
        
        return ans;
    }
}