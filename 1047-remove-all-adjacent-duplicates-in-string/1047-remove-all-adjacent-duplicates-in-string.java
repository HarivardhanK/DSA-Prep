class Solution {
    public String removeDuplicates(String s) {
        //using two pointers
        int end=-1;
        char c[] = s.toCharArray();
        for(char ch:c){
            if(end>=0 && c[end]==ch) end--;
            else c[++end]=ch;
                
        }
        return String.valueOf(c,0,end+1);
    }
}