//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    // TLE
    static boolean isprime(int num) {
        for(int i = 2;i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
    //sieve of Eratothenes
    static void soe(boolean[] primes) {
        int n = primes.length;
        primes[0] = primes[1] = true;
        for(int i = 2; i*i <= n; i++) {
            if(!primes[i]){
                for(int j = i*i; j < n; j+=i) {
                    primes[j] = true;
                }
            }
        }
    }
    
    static String isSumOfTwo(int n){
        // generate all primes till N and apply two sum
        // for(int i = 2; i < n; i++) {
        //     if(isprime(i)) 
        //         primes.add(i);
        // }
        
        boolean[] primes = new boolean[n];
        soe(primes);
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i < n; i++) {
            if(!primes[i]) set.add(i);
        }
        
        for(int ele: set) {
            if(set.contains(n-ele)) return "Yes";
        }
        return "No";
    }
}