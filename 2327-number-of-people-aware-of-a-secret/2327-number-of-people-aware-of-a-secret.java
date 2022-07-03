class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Queue<Long> d = new LinkedList<>();
        Queue<Long> f = new LinkedList<>();
        long pers = 0, mod = 1000000007;
        d.offer((long)1);
        f.offer((long)1);
        
        while(--n > 0) {
            if(d.size() >= delay) {
                pers =(pers + d.poll()) % mod;
            } 
            if(f.size() >= forget) {
                pers = (pers - f.poll() + mod) % mod;
            }
            
            d.offer(pers);
            f.offer(pers);
        }
        long sum = 0;
        for(long i: d) 
            sum = (sum + i) % mod;
        
        return (int)((pers + sum) % mod);
    }
}


/**
n = 6, delay = 2, forget = 4
100000
100100
10011
*/