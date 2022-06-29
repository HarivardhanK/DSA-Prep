class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)-> (a[1]==b[1])?a[0] - b[0]:a[1] - b[1]);
        
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        
        for(int p[]: people) {
            int taller = 0;
            while(!q1.isEmpty()) {
                if(q1.peek()[0] >= p[0]) {
                    taller++;
                }
                if(taller > p[1]) break;
                q2.offer(q1.poll());
            }
            q2.offer(new int[]{p[0], p[1]});
            while(!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            q1 = q2;
            q2 = new LinkedList<>();
        }
        
        int[][] ans = new int[people.length][2];
        int ind = 0;
        while(!q1.isEmpty())
            ans[ind++] = q1.poll();
        return ans;
    }
}


/*
    [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    sort
    [[5,0],[7,0],[6,1],[7,1],[5,2],[4,4]]
    Q1: [5,7,5,6,7]
    Q2: [5,7,5,6,4,7]
    
     [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
     sort
     [[4,0],[5,0],[6,0],[2,2],[3,2],[1,4]]
     Q1: [4,5,2,3,1,6]
     Q2: []
*/