class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, idx2 = 0, i = 0, j =0;
        while(idx1 < word1.length && idx2 < word2.length) {
            if(word1[idx1].charAt(i) != word2[idx2].charAt(j)) return false;
            i++; j++;
            if(i == word1[idx1].length()) {idx1++; i=0;}
            if(j == word2[idx2].length()) {idx2++; j=0;}
        }
        if(idx1 < word1.length || idx2 < word2.length) return false;
        return true;
    }
}