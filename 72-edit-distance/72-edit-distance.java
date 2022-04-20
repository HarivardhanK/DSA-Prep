class Solution {
    public int minDistance(String s, String t) {
        int n=s.length(),m=t.length();
        int prev[] = new int[m+1];
        for(int j=0;j<=m;j++) prev[j] = j;
        
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            curr[0] = i;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else{
                    curr[j] = 1+Math.min(prev[j],Math.min(curr[j-1],prev[j-1]));
                }
            }
            prev=curr;
        }
        return prev[m];
    }
}