//https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
class Solution {
    private int checkPalindrome(String str, int left, int right){
        int count = 0;
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            count++;
            left--;right++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count += checkPalindrome(s, i, i); //for odd length palindrome
            count +=checkPalindrome(s, i, i+1);
        }
        return count;
    }
}