class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> en: map.entrySet()) {
            pq.offer(en.getValue());
        }
        int tele = 0, ele = arr.length/2;
        while(ele > 0 && pq.size() > 0) {
            tele++;
            ele -= pq.poll();
        }
        return tele;
    }
}