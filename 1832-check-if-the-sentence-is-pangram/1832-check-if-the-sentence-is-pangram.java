class Solution {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        
        for(char ch: sentence.toCharArray()) {
            int mappedBit = ch - 'a';
            int currMask = 1 << mappedBit;
            
            mask |= currMask;
        }
        return mask == (1<<26)-1;
    }
}