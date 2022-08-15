class Solution {
    private int strToInt(String str) {
        switch(str) {
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            default: return 0;
        }
    }
    public int romanToInt(String s) {
        int prev = 0, ans = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int num = strToInt(s.charAt(i)+"");
            if(prev > num) {
                ans -= num;
                prev = num;
            }
            else {
                prev = num;
                ans += num;
            }
        }
        return ans;
    }
}