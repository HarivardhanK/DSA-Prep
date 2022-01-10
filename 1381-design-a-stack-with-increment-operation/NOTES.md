**This solution takes O(K) and for every increment we have to loop through k elements**
​
**use lazy increment instead it is nothing but storing values in an array and then when the element gets popped it gives its value to the previous element**
#### Implemented
​
**bruteforce**
​
```
class CustomStack {
int []stack;
int top;
public CustomStack(int maxSize) {
stack = new int[maxSize];
top=-1;
}
public void push(int x) {
if(top<stack.length-1)
stack[++top] = x;
}
public int pop() {
if(top>=0)
return stack[top--];
return -1;
}
public void increment(int k, int val) {
for(int i=0;i<k && i<stack.length;i++){
stack[i]=stack[i]+val;
}
}
}
​
/**
* Your CustomStack object will be instantiated and called as such:
* CustomStack obj = new CustomStack(maxSize);
* obj.push(x);
* int param_2 = obj.pop();
* obj.increment(k,val);
*/
```
​