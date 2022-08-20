[Video Solution](https://youtu.be/4RgqAQFr9WQ)
### Dp solution:
dp array represents
ind -> number of picks of station's fuel
value in index -> maximum distance travelled by picking the 'ind' number of stations
0 - no stations fuel is picked
1 - one station fuel is picked and so on
​
by calculating this array and at the end we can compare our target and dp[index] and return index(no of picks) that best fits
​
```
class Solution {
public int minRefuelStops(int target, int startFuel, int[][] stations) {
int n = stations.length;
long[] dp = new long[n + 1];
dp[0] = startFuel;
for(int i = 0; i < n; i++) {
for(int refil = i; refil >= 0 && dp[refil] >= stations[i][0]; refil--) {
dp[refil + 1] = Math.max(dp[refil + 1], dp[refil] + stations[i][1]);
}
}
for(int i = 0; i <= n; i++) {
if(target <= dp[i]) return i;
}
return -1;
}
}
```
​
### using Priority Queue  - maxHeap
​
​