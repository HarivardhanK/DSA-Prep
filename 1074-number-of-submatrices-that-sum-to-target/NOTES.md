​
​
```
class Solution {
public int numSubmatrixSumTarget(int[][] matrix, int target) {
int m = matrix.length, n = matrix[0].length;
//prefix sum for each row in the matrix
for(int i = 0; i < m; i++) {
for(int j = 1; j < n; j++) {
matrix[i][j] += matrix[i][j - 1];
}
}
int count = 0;
//now for each and every column we find the submats sum to k
for(int c1 = 0; c1 < n; c1++) {
for(int c2 = c1; c2 < n; c2++) {
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
map.put(0, 1);
int sum = 0;
for(int r = 0; r < m; r++) {
sum += matrix[r][c2] - (c1 > 0? matrix[r][c1 - 1]: 0);
count += map.getOrDefault(sum - target, 0);
map.put(sum, map.getOrDefault(sum, 0) + 1);
}
}
}
return count;
}
}
```