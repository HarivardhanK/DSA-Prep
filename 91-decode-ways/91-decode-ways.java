class Solution {
    public int numDecodings(String s) {
        // int dp[] = new int[s.length()+1];
        int next1, next2=0;
        //base conditions
        // dp[s.length()] = 1;
        next1=1;
        
        for(int i=s.length()-1;i>=0;i--){
            int count = 0;
            count += (s.charAt(i)!='0')?next1:0;
            if(i<s.length()-1){
                int num = Integer.parseInt(s.substring(i,i+2));
                count += !(num>9 && num<27)?0:next2;
            }
            next2=next1;
            next1 = count;
        }
        return next1;
    }
}