class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        //Seive of Eratosthenes
        // array of size n
        boolean primes[]=new boolean[n];
        for(int i=3;i*i<=n;i+=2)
            for(int j=2*i;j<n;j+=i)
                //making multiples of i false
                primes[j]=true;
        int count=1;
        for(int i=3;i<n;i+=2)
            if(!primes[i]) count++;
        return count;
    }
}