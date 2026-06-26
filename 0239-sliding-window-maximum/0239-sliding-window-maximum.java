class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0) return new int[0];

        int len = nums.length;
        int[] result = new int[len-k+1];
        int idx = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<len;i++){

            if(!q.isEmpty() && q.peek() == i - k){
                q.poll();
            }

            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            q.offer(i);

            if(i >= k-1) result[idx++] = nums[q.peek()];

        }
        return result;
    }
}