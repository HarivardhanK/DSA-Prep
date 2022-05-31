class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length() - k + 1; i++){
            if(!set.contains(s.substring(i,i + k)))
                set.add(s.substring(i,i + k));
        }
        if(set.size() >= (1 << k))
            return true;
        return false;
    }
}