###  Using priority Queue
TC : O(NlogK) and SC: O(K)
```
class Solution {
public int maxResult(int[] nums, int k) {
//int[2] -> index 0 = index of the nums , index 1 = value at index
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[1] - a[1]);
int max = nums[0];
// initially offer the 0th index value to the pq as we need to start from it
pq.offer(new int[]{0, nums[0]});
// iterate from the 1 to length of array
for(int i = 1; i < nums.length; i++) {
// remove the elements which are out of the window K from the queue
while(i - pq.peek()[0] > k )
pq.poll();
// pick the element and add that ele with our current index
max = pq.peek()[1] + nums[i];
//again offer the the max with the current index
pq.offer(new int[]{i, max});
}
// return previously computed maximum value
return max;
}
}
```