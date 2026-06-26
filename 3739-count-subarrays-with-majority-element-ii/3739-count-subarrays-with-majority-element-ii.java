class Solution {

    class FenwickTree {
        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 2];
        }

        void update(int index, int value) {
            while (index < bit.length) {
                bit[index] += value;
                index += index & (-index);
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Prefix sums
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                prefix[i + 1] = prefix[i] + 1;
            else
                prefix[i + 1] = prefix[i] - 1;
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int value : sorted) {
            if (!map.containsKey(value)) {
                map.put(value, rank++);
            }
        }

        FenwickTree ft = new FenwickTree(rank);

        long ans = 0;

        for (int value : prefix) {

            int index = map.get(value);

            // Count previous prefix sums < current prefix sum
            ans += ft.query(index - 1);

            // Insert current prefix sum
            ft.update(index, 1);
        }

        return ans;
    }
}