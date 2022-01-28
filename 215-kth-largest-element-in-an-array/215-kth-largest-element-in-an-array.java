class Solution {
    int minHeap(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
    public int findKthLargest(int[] nums, int k) {
        return minHeap(nums, k);
    }
}