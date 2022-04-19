class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int prev[] = new int[n];
        
        for(int i=n-1;i>=0;i--){
            int curr[] = new int[n];
            curr[i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    curr[j] = 2 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}