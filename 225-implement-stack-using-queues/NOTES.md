### Using the two Queues
​
```
class MyStack {
Queue<Integer> q1,q2;
public MyStack() {
q1=new LinkedList<>();
q2=new LinkedList<>();
}
public void push(int x) {
q1.offer(x);
//we are reversing the queue by doing this
while(!q2.isEmpty()) q1.offer(q2.poll());
//swap the q1 and q2
//to get the top element in the stack
//we need to reverse the queue
//this swapping makes it reverse
//q2 will be empty
Queue<Integer> qtemp = q2;
q2 = q1;
q1 = qtemp;
}
public int pop() {
return q2.poll();
}
public int top() {
return q2.peek();
}
public boolean empty() {
return !(q2.size()>0);
}
}
​
/**
* Your MyStack object will be instantiated and called as such:
* MyStack obj = new MyStack();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.top();
* boolean param_4 = obj.empty();
*/
```
​
### Using the one queue
​
```
​
```