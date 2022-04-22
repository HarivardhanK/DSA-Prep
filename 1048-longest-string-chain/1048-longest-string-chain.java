class Solution {
    private boolean checkPos(String s, String t){
        if(s.length() != t.length()+1) return false;
        int sind=0,tind=0;
        while(sind < s.length()){
            if(tind<t.length() && t.charAt(tind)==s.charAt(sind)){
                tind++;
                sind++;
            }
            else{
                sind++;
            }
        }
        if(tind==t.length() && sind==s.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b)->a.length() - b.length());
        
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max=1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(checkPos(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}