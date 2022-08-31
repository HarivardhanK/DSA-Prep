class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        PriorityQueue<String[]> pq = new PriorityQueue<>(
            (a,b) -> (a[1].equals(b[1]))?
                     a[0].compareTo(b[0]):
                     a[1].compareTo(b[1]));
        
        List<String> diglogs = new ArrayList<>();
        
        for(int i = 0; i < logs.length; i++) {
            String s = logs[i].split(" ")[1];
            if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
                String id = logs[i].split(" ")[0];
                pq.add(new String[]{id, logs[i].substring(id.length())});
            }
            else {
                diglogs.add(logs[i]);
            }
        }
        
        int i = 0;
        while(pq.size() > 0) {
            String[] log = pq.poll();
            logs[i] = log[0]+log[1];
            i++;
        }
        int j = 0;
        while(i < logs.length) {
            logs[i++] = diglogs.get(j++);
        }
        return logs;
    }
}