class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        // Find maximum value in nums
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        // Step 1: Frequency array
        int[] freq = new int[max + 1];
        for (int num : nums)
            freq[num]++;

        // Step 2: Count how many numbers are divisible by each d
        int[] divisibleCount = new int[max + 1];

        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                divisibleCount[d] += freq[multiple];
            }
        }

        // Step 3: Count pairs divisible by d
        long[] exactPairs = new long[max + 1];

        for (int d = 1; d <= max; d++) {
            long cnt = divisibleCount[d];
            exactPairs[d] = cnt * (cnt - 1) / 2;
        }

        // Step 4: Inclusion-Exclusion
        // Remove pairs whose gcd is actually a multiple of d
        for (int d = max; d >= 1; d--) {

            for (int multiple = d * 2; multiple <= max; multiple += d) {
                exactPairs[d] -= exactPairs[multiple];
            }
        }

        // Step 5: Prefix Sum
        long[] prefix = new long[max + 1];

        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exactPairs[d];
        }

        // Step 6: Answer Queries
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[i] = left;
        }

        return ans;
    }
}