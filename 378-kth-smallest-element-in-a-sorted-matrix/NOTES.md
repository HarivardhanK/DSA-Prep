### Using PriorityQueue: TC: O(n^2 * logK) and SC: O(K)
```
class Solution {
public int kthSmallest(int[][] matrix, int k) {
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
for(int i = 0; i < matrix.length; i++) {
for(int j = 0; j < matrix[0].length; j++) {
pq.offer(matrix[i][j]);
if(pq.size() > k) pq.poll();
}
}
return pq.poll();
}
}
```
### Using Binary Search: TC: O(n*log(max)) and SC: O(1)