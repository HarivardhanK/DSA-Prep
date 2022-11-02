class Solution {
    int ans = (int)1e9;
    private boolean valid(String st, String nex) {
        int cnt = 0;
        for(int i = 0;i < st.length(); i++) {
            if(st.charAt(i) != nex.charAt(i)) cnt++;
        }
        return (cnt == 1);
    }
    private void minmuts(String st, String en, String[] bk, boolean[] vis, int op) {
        if(st.equals(en)) {
            ans = Math.min(ans, op); 
            return;
        }
        for(int i = 0; i < bk.length; i++) {
            if(!vis[i] && valid(st, bk[i])) {
                vis[i] = true;
                minmuts(bk[i], en, bk, vis, op+1);
                vis[i] = false;
            }
        }
    }
    public int minMutation(String start, String end, String[] bank) {
        minmuts(start, end, bank, new boolean[bank.length], 0);
        return (ans==(int)1e9)?-1:ans;
    }
}