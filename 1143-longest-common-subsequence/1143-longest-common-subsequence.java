class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(),n2=text2.length();
        int prev[] = new int[n2+1];
        for(int j=0;j<=n2;j++) prev[j]=0;
        
        for(int ind1=1;ind1<=n1;ind1++){
            int curr[] = new int[n2+1];
            curr[0]=0;
            for(int ind2=1;ind2<=n2;ind2++){
                if(text1.charAt(ind1-1)==text2.charAt(ind2-1))
                    curr[ind2]=1+prev[ind2-1];
                else
                    curr[ind2]=Math.max(prev[ind2],curr[ind2-1]);
            }
            prev=curr;
        }
        return prev[n2];
    }
}