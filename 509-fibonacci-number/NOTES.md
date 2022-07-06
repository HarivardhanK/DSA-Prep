```
class Solution {
public int fib(int n) {
//recursive:
// return (n==0||n==1)?n:fib(n-1)+fib(n-2);
//iterative
int first=0,next=1,curr;
for(int i=1;i<=n;i++){
curr=first+next;
first=next;
next=curr;
}
return first;
}
}
```