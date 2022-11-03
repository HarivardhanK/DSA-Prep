class Solution {
private int longestPalin(String[] words, int idx, String word) {
if(idx == words.length) {
if(word.equals(new StringBuilder(word).reverse().toString()))
return word.length();
else return -(int)1e9;
}
int first = longestPalin(words, idx+1, words[idx]+word);
int last = longestPalin(words, idx+1, word+words[idx]);
int mid = 0, n = word.length();
if(n != 0 && n%2 == 0)
mid = longestPalin(words, idx+1, word.substring(0, n/2)+words[idx]+word.substring(n/2));
int max = Math.max(first, Math.max(last, mid));
max = Math.max(max, longestPalin(words, idx+1, word));
return max;
}
public int longestPalindrome(String[] words) {
return longestPalin(words, 0, "");
}
}