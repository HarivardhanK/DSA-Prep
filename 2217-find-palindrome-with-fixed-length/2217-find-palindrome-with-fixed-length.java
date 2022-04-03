class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long qres[] = new long[queries.length];
        int ind=0;
        int pw = (intLength%2==0)?(intLength/2-1):(intLength/2);
        long start = (long)Math.pow(10,pw);
        for(int q:queries){
            StringBuilder ans = new StringBuilder(""+(start+q-1));
            StringBuilder rev = new StringBuilder(ans);
            rev.reverse();
            if(intLength%2==0){
                ans.append(rev);
            }
            else{
                ans.append(rev.substring(1));
            }
            if(ans.length()==intLength) qres[ind++]=Long.parseLong(ans.toString());
            else qres[ind++]=-1;
        }
        return qres;
    }
}