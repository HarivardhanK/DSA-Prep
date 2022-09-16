[Solution](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/discuss/1423198/Java-basic-minHeap-Dijkstra-with-minor-changes)
​
```
class Solution {
private List<List<int[]>> createGraph(int[][] roads, int n) {
List<List<int[]>> adj = new ArrayList<>();
for(int i = 0; i < n; i++)
adj.add(new ArrayList<>());
for(int[] road: roads) {
adj.get(road[0]).add(new int[]{road[1], road[2]});
adj.get(road[1]).add(new int[]{road[0], road[2]});
}
return adj;
}
public int countPaths(int n, int[][] roads) {
List<List<int[]>> adj = createGraph(roads, n);
int MOD = (int)1e9 + 7;
//apply dijkstra's algo
int[] dis = new int[n];
Arrays.fill(dis, Integer.MAX_VALUE);
int[] ways = new int[n];