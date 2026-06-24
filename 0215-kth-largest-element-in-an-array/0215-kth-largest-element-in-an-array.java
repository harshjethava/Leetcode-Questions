class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int len = nums.length;

        for(int i=0;i<len;i++){
            pq.offer(nums[i]);
        }

        int idx = len - k;
        for(int i=0;i<idx;i++){
            pq.poll();
        }
        return pq.peek();
        
    }
}