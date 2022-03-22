class Solution {
    public String getSmallestString(int n, int k) {
        char ch[] = new char[n];
        for(int i=0;i<ch.length;i++) ch[i]='a';
        k-=n;
        int i=ch.length-1;
        while(k>0){
            if(k<25){
                ch[i--]+=k;
                k=0;
            }
            else{
                ch[i--]+=25;
                k-=25;
            }
        }
        return String.valueOf(ch);
    }
}