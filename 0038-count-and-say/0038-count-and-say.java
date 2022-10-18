class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        if(n == 1) return ans;
        for(int i = 1; i < n; i++) {
            int cnt = 0, idx = 0;
            char currnum = ans.charAt(0);
            
            String t = "";
            boolean rep = false;
            while(idx < ans.length()) {
                if(currnum == ans.charAt(idx)){ cnt++; idx++; }
                else {
                    t += cnt +""+ currnum;
                    currnum = ans.charAt(idx);
                    cnt = 0;
                }
            }
            if(cnt > 0){
                t += cnt;
                t += currnum;
            }
            ans = t;
        }
        return ans;
    }
}