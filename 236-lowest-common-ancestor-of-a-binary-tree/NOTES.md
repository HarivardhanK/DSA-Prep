https://assets.leetcode.com/uploads/2018/12/14/binarytree.png
​
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
​
### Approach 1 :
It can also be solved by finding each node's path from the root
for node '5' : [3,5] space complexity is O(N)
for node '4' : [3,5,2,4]  space complexityis O(N)
total of O(2N)
then LowestcommonAncestor of 5 and 4 is '3'
​
### Approach 2:
without using any auxilary space by recursion:
[striver Solution Video](https://www.youtube.com/watch?v=_-QHfMDde90&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=30)