Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
​
**TreeMap ds:**
* row(x)   col(y)   values/priorityQueue(maintains list in sorted order(ascending order))
* 0            0          1
* -1           1          2
* 1             1          3
* -2            2          4
* 0             2         {5,6}
* 2             2          7
​
Answer List will be
{}
row -2:   col 2 : {4}
{{4}}
​
row -1:   col 1 : {2}
{{4},{2}}
​
row 0 :   col 0 : {1}
col 2 :{1,5,6}
{{4},{2},{1,5,6}}
​
row 1:   col 1 : {3}
{{4},{2},{1,5,6},{3}}
​
row 2 : col 2: {7}
{{4},{2},{1,5,6},{3},{7}}
​
**Output**
{{4},{2},{1,5,6},{3},{7}}
​
​
​
​
​
# Using Preorder Traversal:
```
class Solution {
​
public List<List<Integer>> verticalTraversal(TreeNode root) {
TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
​
solve(root, map, 0, 0);
​