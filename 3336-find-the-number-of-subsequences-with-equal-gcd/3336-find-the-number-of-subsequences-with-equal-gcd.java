class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        // dp[i][g1][g2]
        int[][][] dp = new int[n + 1][201][201];
        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int g1 = 0; g1 <= 200; g1++) {
                for (int g2 = 0; g2 <= 200; g2++) {

                    if (dp[i][g1][g2] == 0) continue;

                    long ways = dp[i][g1][g2];

                    // Ignore
                    dp[i + 1][g1][g2] =
                            (int) ((dp[i + 1][g1][g2] + ways) % MOD);

                    // Put in seq1
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    dp[i + 1][ng1][g2] =
                            (int) ((dp[i + 1][ng1][g2] + ways) % MOD);

                    // Put in seq2
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    dp[i + 1][g1][ng2] =
                            (int) ((dp[i + 1][g1][ng2] + ways) % MOD);
                }
            }
        }

        long ans = 0;
        for (int g = 1; g <= 200; g++) {
            ans = (ans + dp[n][g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}