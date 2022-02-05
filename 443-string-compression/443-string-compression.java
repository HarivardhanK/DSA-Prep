class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int k=0;
        for(int i=0;i<chars.length;){
            chars[k++]=chars[i];
            int j=i;
            while(j<chars.length && chars[i]==chars[j]) j++;
            int revnum=0;
            int n=j-i;
            if(n>1){
                int digits=0;
                while(n>0){
                    revnum= n%10 + revnum*10;
                    n/=10;
                    digits++;
                }
                while(digits-->0 || revnum>0){
                    chars[k++]=(char)('0'+(revnum%10));
                    revnum/=10;
                }
            }
            i=j;
        }
        
        return k;
    }
}