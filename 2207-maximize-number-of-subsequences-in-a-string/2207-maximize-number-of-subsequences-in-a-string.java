class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        String s=pattern.charAt(0)+text;
        long ans=0,ans1=0;
        long c1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==pattern.charAt(0)) c1++;
            else if(s.charAt(i)==pattern.charAt(1)) ans+=c1;
        }
        if(pattern.charAt(0)==pattern.charAt(1))  ans=(c1*(c1-1))/2;
        else{
            s=text+pattern.charAt(1);
            c1=0;
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)==pattern.charAt(1)) c1++;
                else if(s.charAt(i)==pattern.charAt(0)) ans1+=c1;
            }
        }
        return Math.max(ans,ans1);
    }
}