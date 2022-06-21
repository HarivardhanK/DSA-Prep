class Solution {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length(), nlen = needle.length();
        for(int i = 0; i < hlen; i++) {
            int start = i;
            int j = 0;
            while(start < hlen && j < nlen && haystack.charAt(start) == needle.charAt(j)) {
                j++; start++;
            }
            if(j == nlen) return i;
        }
        return -1;
    }
}