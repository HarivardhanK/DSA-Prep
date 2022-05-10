class Solution {
    private long power(long n, long i){
        if(i==0) return 1;
        
        long ans = power(n,i/2);
        
        return (ans * ans * (i%2==0? 1: n))%1000000007;
    }
    public int countGoodNumbers(long n) {
        return (int)((power(4,(n/2)) * power(5,(n+1)/2))%1000000007);
        // return (int)((power(5,(n+1)/2) * power(4,n/2)) % 1000000007) ; 
    }
}

