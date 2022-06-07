class Solution {
    private double pow(double x, int n) {
        if(n == 0)
            return 1;
        return x * pow(x, n - 1);
    }
    private double power(double x, int n) {
        if(n == 0) 
            return 1;
        double p = power(x, n/2);
        return (n%2 == 0)? p * p: p * p * x;
    }
    public double myPow(double x, int n) {
       return (n < 0)? 1/power(x, -n): power(x, n);
    }
}