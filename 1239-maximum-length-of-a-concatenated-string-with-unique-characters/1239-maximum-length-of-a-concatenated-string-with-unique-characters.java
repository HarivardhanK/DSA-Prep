class Solution {
    private int solve(List<String> arr, int[][] map, int prev, int idx) {
        if(idx == arr.size()) return 0;
        
        if((prev&map[idx][0]) == 0) {
            return Math.max(map[idx][1]+solve(arr, map, prev|map[idx][0], idx+1), 
                           solve(arr, map, prev, idx+1));
        }
        return solve(arr, map, prev, idx+1);
    }
    public int maxLength(List<String> arr) {
        int[][] map = new int[arr.size()][2];
        for(int i = 0;i < arr.size(); i++) {
            map[i][1] = arr.get(i).length();
            for(char ch: arr.get(i).toCharArray()) {
                int setbit = 1<<(ch-'a');
                if((map[i][0]&setbit) == (1<<(ch-'a'))) {
                    map[i][0] = 0;
                    map[i][1] = 0;
                    break;
                }
                else {
                    map[i][0] = map[i][0]|setbit;
                }
            }
        }
        return solve(arr, map, 0, 0);
    }
}