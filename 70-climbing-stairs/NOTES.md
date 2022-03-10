Naive Recursive solution:
​
```
class Solution {
public int climbstairsHelper(int n){
if(n<0) return 0;
if(n==0 || n==1){
return 1;
}
return climbstairsHelper(n-1)+climbstairsHelper(n-2);
}
public int climbStairs(int n){
return climbstairsHelper(n);
}
}
```