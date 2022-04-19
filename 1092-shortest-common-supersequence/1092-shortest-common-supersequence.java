class Solution {
    public String lcsstring(String text1, String text2) {
         int n1=text1.length(),n2=text2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++) dp[i][0]=0;
        for(int j=0;j<=n2;j++) dp[0][j]=0;
        
        for(int ind1=1;ind1<=n1;ind1++){
            for(int ind2=1;ind2<=n2;ind2++){
                if(text1.charAt(ind1-1)==text2.charAt(ind2-1))
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=n1,j=n2;
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(text1.charAt(i-1));
                i--;
            }
            else{
                sb.append(text2.charAt(j-1));
                j--;
            }
        }
        //if either of them doesn't reach to the (0,0) then just append last char
        while(i==0 && j!=0){
            sb.append(text2.charAt(j-1));
            j--;
        }
        while(i!=0 && j==0){
            sb.append(text1.charAt(i-1));
            i--;
        }
        
        return sb.reverse().toString();
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcsstring(str1,str2);
    }
}