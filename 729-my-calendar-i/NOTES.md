### Brute Force: TC: O(N^2) and SC: O(no. of unique bookings) -> O(n)
```
class MyCalendar {
List<int[]> arr;
public MyCalendar() {
arr = new ArrayList<>();
}
public boolean book(int start, int end) {
for(int[] node: arr) {
if(node[0] < end && start < node[1])
return false;
}
arr.add(new int[]{start, end});
return true;
}
}
```
### Using TreeMap TC: O(nlogn) and SC: O(N)
The Tree Map class in java is Red=black tree based implementation.It provides an efficient means of storing the key-value pairs in sorted order.
```
​
```