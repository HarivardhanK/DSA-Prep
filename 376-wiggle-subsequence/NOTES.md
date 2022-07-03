[Solution link - leetcode](https://leetcode.com/problems/wiggle-subsequence/solution/)
## to be solved in Dp
​
​
### Greedy algo for this prob
**Complexity Analysis**
Time complexity : O(n). We traverse the given array once.
Space complexity : OO(1). No extra space is used.
​
Algorithm
We need not necessarily need dp to solve this problem. This problem is equivalent to finding the number of alternating max. and min. peaks in the array. Since, if we choose any other intermediate number to be a part of the current wiggle subsequence, the maximum length of that wiggle subsequence will always be less than or equal to the one obtained by choosing only the consecutive max. and min. elements.
​
​
​