class Solution {
    private int numways(String s, int i, int dp[]){
        if(i>=s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int count = 0;
        count += numways(s,i+1,dp);
        if(i<s.length()-1){
            int num = Integer.parseInt(s.substring(i,i+2));
            count += !(num>9 && num<27)?0:numways(s,i+2,dp);
        }
        return dp[i] = count;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        // Arrays.fill(dp,-1);
        // return numways(s,0,dp);
        
        //base conditions
        dp[s.length()] = 1;
        for(int i=s.length()-1;i>=0;i--){
            int count = 0;
            count += (s.charAt(i)!='0')?dp[i+1]:0;
            if(i<s.length()-1){
                int num = Integer.parseInt(s.substring(i,i+2));
                count += !(num>9 && num<27)?0:dp[i+2];
            }
            dp[i] = count;
        }
        return dp[0];
        
        
    }
}