class Solution {
    private void reverse(char[] ch, int s, int e) {
        while(s < e) {
            char t = ch[s];
            ch[s] = ch[e];
            ch[e] = t;
            s++;e--;
        }
    }
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length; i++) {
            int j = i;
            while(j < ch.length && ch[j] != ' ') j++;
            reverse(ch, i, j-1);
            i=j;
        }
        return String.valueOf(ch);
    }
}