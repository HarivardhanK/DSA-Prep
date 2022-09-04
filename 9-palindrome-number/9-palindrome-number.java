class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return new StringBuilder(x+"").reverse().toString().equals(x+"");
    }
}