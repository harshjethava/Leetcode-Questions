class Solution {
    public int findLongestChain(int[][] pairs) {

        // Sort by the second element 
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        // smallest possible value
        int currentEnd = Integer.MIN_VALUE; 

        for (int[] pair : pairs) {
            if (currentEnd < pair[0]) {
                count++;
                currentEnd = pair[1]; // Update to the new end
            }
        }

        return count;
        
    }
}