using two stacks one for normal stack operations and other for the storing only the mininum number in stack.
​
```
class MinStack {
Stack<Integer> stk,minstk;
public MinStack() {
stk=new Stack<>();
minstk=new Stack<>();
}
public void push(int val) {
stk.push(val);
if(minstk.size()==0 || val<minstk.peek()) minstk.push(val);
}
public void pop() {
int n = stk.pop();
if(minstk.size()>0 && n==minstk.peek()) minstk.pop();
}
public int top() {
return stk.peek();
}
public int getMin() {
return minstk.peek();
}
}
​
```