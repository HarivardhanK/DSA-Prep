class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int res = 0;
        while(a - b >= 0){
            int x = 0;
            // b << x + 1 is not same of b << 1 << x
            while(a - (b << x << 1) >= 0){
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return (dividend < 0) == (divisor < 0) ? res : -res;
    }
}