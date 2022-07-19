class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(1);
        ans.add(level);
        int size = 1;
        for(int i = 1; i < numRows; i++) {
            size += 1;
            level = new ArrayList<>();
            level.add(1);
            for(int ind = 1; ind < size -1; ind++) {
                level.add(ans.get(ans.size() - 1).get(ind - 1) + ans.get(ans.size() - 1).get(ind));
            }
            level.add(1);
            ans.add(level);
        }
        return ans;
    }
}


//1
//1 1
//1 2 1
//1 3