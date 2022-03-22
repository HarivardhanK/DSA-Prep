class Solution {
    public void reverse(char[] ch, int i,int j){
        while(i<j){
            char c = ch[i];
            ch[i]=ch[j];
            ch[j]=c;
            i++;j--;
        }
    }
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            int j=i;
            while(j<ch.length && ch[j]!=' ') j++;
            reverse(ch,i,j-1);
            i=j;
        }
        return String.valueOf(ch);
    }
}