class Solution {
    int mod = (int)1e9+7;
    private long power(long a, long b) {
        long x = a, ans = 1;
        while(b > 0) {
            if((b&1) == 1) 
                ans = (ans*x)%mod;
            x = (x*x)%mod;
            b>>=1;
        }
        return (int)(ans%mod);
    }
    public int concatenatedBinary(int n) {
        long ans = 0, count = 0;
        for(int i = n; i > 0; i--) {
            ans = (ans + (i*power(2,count))%mod)%mod;
            count += (int)(Math.log10(i)/Math.log10(2))+1;
            // System.out.println(count+" "+ans);
        }
        return (int)ans%mod;
    }
}