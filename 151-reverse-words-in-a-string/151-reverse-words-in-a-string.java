class Solution {
    public String reverseWords(String s) {
        String[] str= s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(str[str.length-1].trim());
        for(int i=str.length-2;i>=0;i--){
            if(str[i].length()>0) sb.append(" "+str[i].trim());
        }
        return sb.toString();
    }
}