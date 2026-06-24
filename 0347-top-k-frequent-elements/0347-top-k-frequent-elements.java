class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a Max-Heap PriorityQueue that sorts by frequency (the Map value) in decreasing order
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );

        // Add all map entries to the priority queue
        maxHeap.addAll(frequencyMap.entrySet());
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res[i] = entry.getKey();
        }
        return res;
    }
}