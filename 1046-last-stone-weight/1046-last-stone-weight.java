class Solution {
    public int lastStoneWeight(int[] s) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int len = s.length;

        for(int i=0;i<len;i++){
            pq.offer(s[i]);
        }

        while(!pq.isEmpty()){

            int top1 = pq.peek();
            pq.poll();
            if(pq.isEmpty()) return top1;

            int top2 = pq.peek();
            pq.poll();
            pq.offer(top1 - top2);

        }
        return 0;
        
    }
}