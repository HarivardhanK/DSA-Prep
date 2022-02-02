class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        if(n==3) return 1;
        //Seive of Eratosthenes
        // array of size n
        boolean primes[]=new boolean[n];
        for(int i=2;i<n;i++) 
            primes[i]=true;
        for(int i=2;i*i<=n;i++)
            for(int j=2*i;j<n;j+=i)
                //making multiples of i false
                primes[j]=false;
        int count=0;
        for(int i=2;i<n;i++) 
            if(primes[i]) count++;
        return count;
    }
}