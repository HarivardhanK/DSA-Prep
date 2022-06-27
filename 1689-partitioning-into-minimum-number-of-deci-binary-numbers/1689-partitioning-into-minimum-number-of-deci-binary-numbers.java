class Solution {
    public int minPartitions(String n) {
        char maxChar = '0';
        for(char ch: n.toCharArray()) {
            if(maxChar < ch) 
                maxChar = ch;
        }
        return maxChar - '0';
    }
}