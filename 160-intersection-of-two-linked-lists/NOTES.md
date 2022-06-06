### Using an extra space: set: o(n)&O(n)
```
public class Solution {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
Set<ListNode> set = new HashSet<>();
while(headA != null){
set.add(headA);
headA = headA.next;
}
while(headB != null){
if(set.contains(headB))
return headB;
headB = headB.next;
}
return null;
}
}
```
### constant space solution:
Idea:
The naive approach here would be to store each node reference in a data structure until we saw the same one twice, but that would take O(N) extra space.
​
In order to solve this problem with only O(1) extra space, we'll need to find another way to align the two linked lists. More importantly, we need to find a way to line up the ends of the two lists. And the easiest way to do that is to concatenate them in opposite orders, A+B and B+A. This way, the ends of the two original lists will align on the second half of each merged list.
### refer this link:
https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/1092898/JS-Python-Java-C%2B%2B-or-Easy-O(1)-Extra-Space-Solution-w-Visual-Explanation