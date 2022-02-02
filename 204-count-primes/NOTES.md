time conplexity of O(Nsqrt(N)) -- TLE
```
class Solution {
public boolean isPrime(int n){
if(n<=1) return false;
if(n==2) return true;
for(int i=3;i*i<=n;i+=2)
if(n%i==0) return false;
return true;
}
public int countPrimes(int n) {
if(n<=1) return 0;
int count = 0;
if(n>2) count=1;
for(int i=3;i<n;i+=2){
if(isPrime(i)) count++;
}
return count;
}
}
```