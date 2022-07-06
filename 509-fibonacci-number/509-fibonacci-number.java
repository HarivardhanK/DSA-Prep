class Solution {
    public int fib(int n) {
        //recursive appraoch
        // return (n <= 1)?n:fib(n - 1) + fib(n - 2);
        //iterative approach
        int prev = 0, curr = 1;
        while(n-- > 0) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return prev;
    }
}