class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        
        Arrays.sort(intervals, (a, b)-> (a[0] == b[0])?a[1] - b[1] :a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                List<Integer> ts = new ArrayList<>();
                ts.add(start);
                ts.add(end);
                ans.add(ts);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        List<Integer> ts = new ArrayList<>();
        ts.add(start);
        ts.add(end);
        ans.add(ts);
        int[][] ansarr = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            ansarr[i][0] = ans.get(i).get(0);
            ansarr[i][1] = ans.get(i).get(1);
        }
        return ansarr;
    }
}