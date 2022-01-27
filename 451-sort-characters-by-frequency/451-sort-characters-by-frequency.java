class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch=ch;
        this.freq=freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    if(a.freq == b.freq)
                        return a.ch - b.ch;
                    return b.freq - a.freq;
                }
            }
        );
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder str = new StringBuilder();
        while(pq.size()>0){
            Pair p = pq.poll();
            int fr =p.freq;
            while(fr-->0) str.append(p.ch);
        }
        return str.toString();
    }
}