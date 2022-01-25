class Solution {
    int minHeap(int[] arr, int k){
        PriorityQueue<Integer> s = new PriorityQueue<>();
        if(s.isEmpty()) s.offer(arr[0]);
        for(int i=1;i<arr.length;i++){
            s.offer(arr[i]);
            if(s.size()>k) s.poll();
        }
        return s.peek();
    }
    public int findKthLargest(int[] nums, int k) {
        return minHeap(nums, k);
    }
}