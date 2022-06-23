class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int[] course: courses) {
            if(time + course[0] <= course[1]) {
                pq.offer(course[0]);
                time += course[0];
            }
            else if(!pq.isEmpty() && pq.peek() > course[0]){
                time += course[0] - pq.poll();
                pq.offer(course[0]);
            }
        }
        return pq.size();
    }
}