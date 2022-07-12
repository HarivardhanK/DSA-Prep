if(pq.peek() == max) {
ans++;
pq.poll();
}
else {
int first = pq.poll();
int second = 0;
if(pq.isEmpty()) return false;
second = pq.poll();
pq.offer(first + second);
}
}
if(ans !=0 && ans%4 == 0) return true;
return false;
}
}
```
​
### Recursively checking for four sides
```
class Solution {
boolean solve(int[] ms, int i, int part1, int part2, int part3, int part4) {
if(i == ms.length) {
return (part1 == part2 && part2 == part3 && part3 == part4);
}
if(solve(ms, i + 1, part1 + ms[i], part2, part3, part4))
return true;
if(solve(ms, i + 1, part1, part2 + ms[i], part3, part4))
return true;
if(solve(ms, i + 1, part1, part2, part3 + ms[i], part4))
return true;
return solve(ms, i + 1, part1, part2, part3, part4 + ms[i]);
}
public boolean makesquare(int[] matchsticks) {
// return solve(matchsticks, 0, 0, 0, 0, 0);
return false;
}
}
```