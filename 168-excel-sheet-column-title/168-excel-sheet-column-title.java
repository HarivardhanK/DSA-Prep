class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans=new StringBuilder();
        while(columnNumber > 0){
            ans.append((char)((columnNumber-1)%26 + 'A'));
            columnNumber = (columnNumber-1)/26;
        }
        return ans.reverse().toString();
    }
}