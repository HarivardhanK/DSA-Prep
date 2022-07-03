video for solutoin:
https://www.youtube.com/watch?v=V7QVZY84KQ8
### my approach: using queue
https://leetcode.com/problems/number-of-people-aware-of-a-secret/discuss/2229808/Two-Queues
```
class Solution {
public int peopleAwareOfSecret(int n, int delay, int forget) {
long[] d = new long[delay];
long[] f = new long[forget];
long per = 0;
d[d.length - 1] = 1;
f[f.length - 1] = 1;
for(int i = 1; i < n; i++) {
long pers = per;
pers += d[0];
pers -= f[0];
per = pers;
for(int  j = 1; j < d.length; j++) {
d[j - 1] = d[j];
}
for(int j = 1; j < f.length; j++) {
f[j - 1] = f[j];
}
d[d.length - 1] = pers;