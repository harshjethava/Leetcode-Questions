class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put((long) num, countMap.getOrDefault((long) num, 0) + 1);
        }

        int maxLength = 0;

        if (countMap.containsKey(1L)) {
            int countOfOnes = countMap.get(1L);
            maxLength = (countOfOnes % 2 != 0) ? countOfOnes : countOfOnes - 1;
        }

        for (long x : countMap.keySet()) {
            if (x == 1) {
                continue;
            }

            int currentLength = 0;
            long currentNum = x;

            while (countMap.containsKey(currentNum)) {
                if (countMap.get(currentNum) >= 2) {
                    currentLength += 2;
                    currentNum = currentNum * currentNum;
                } else {
                    currentLength += 1;
                    break;
                }
            }
            
            if (!countMap.containsKey(currentNum)) {
                currentLength -= 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return Math.max(maxLength, 1);
    
    }
}