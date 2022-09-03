class Solution {
    void solve(int n, int k, int ni, List<Integer> ans, String val) {
        if(ni == n) { ans.add(Integer.parseInt(val)); return;}
        
        for(int i = 0; i <= 9; i++) {
            int prevdig = (int)(val.charAt(val.length() - 1) - '0');
            if(Math.abs(prevdig - i) == k) {
                solve(n, k, ni+1, ans, val+i);
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
            solve(n, k, 1, ans, ""+i);
        
        int[] ar = new int[ans.size()];
        for(int i = 0;i < ans.size(); i++) 
            ar[i] = ans.get(i);
        
        return ar;
    }
}