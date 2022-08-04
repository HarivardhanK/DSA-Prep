class Solution {
    public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        while(m * p != n * q) {
            if(m * p < n* q) m++;
            else n++;
        }
        if(m % 2 == 0) return 0;
        else if(n % 2 == 0) return 2;
        return 1;
    }
}
/*
100
3
10
3
9
3
333
3
9
3
9
4
9
5
9
9
*/