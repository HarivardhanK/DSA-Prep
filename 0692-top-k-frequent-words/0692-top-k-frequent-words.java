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
            (a,b)->(a.freq==b.freq)?a.word.compareTo(b.word):b.freq-a.freq);
        for(Map.Entry<String, Integer> en: map.entrySet()) {
            pq.offer(new Pair(en.getKey(), en.getValue()));
        }
        List<String> ans = new ArrayList<>();
        while(k--> 0) ans.add(pq.poll().word);
        return ans;
    }
}