class Solution {
    
    int lowInd = 0, maxLen = 0;
    
    private void expandPalin(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }
        
        if(maxLen < (j - i - 1)) {
            maxLen = j - i - 1;
            lowInd = i + 1;
        }
    }
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        
        for(int i = 0; i < s.length(); i++) {
            expandPalin(s, i, i);
            expandPalin(s, i, i + 1);
        }
        return s.substring(lowInd, lowInd + maxLen);
    }
}


/*
Instead of finding the longest palin by checking for each start and end indexes - O(N^3)
N - for every startIndex * N - for every endIndex * N - for checking palin of (i, j)
try expanding the palindrome for each character of the string as a middle char of palin
the palin's len can be of size even or odd check for both
*/