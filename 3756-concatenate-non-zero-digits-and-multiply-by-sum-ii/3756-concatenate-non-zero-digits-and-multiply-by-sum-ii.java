import java.util.Arrays;

class Solution {
    private static final int MOD = 1000000007;

    // Helper method to compute (base^exp) % MOD using binary exponentiation
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    // Helper method to compute the Modular Multiplicative Inverse ( Fermat's Little Theorem)
    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();

        // 1. Prefix sum array for digit sums (includes zeros, as zeros add 0 to sum)
        int[] digitPrefix = new int[m + 1];
        for (int i = 0; i < m; i++) {
            digitPrefix[i + 1] = digitPrefix[i] + (s.charAt(i) - '0');
        }

        // 2. Precompute active non-zero mapping configurations
        // numPrefix[i] stores the value of the non-zero string up to index i (modulo MOD)
        long[] numPrefix = new long[m + 1];
        // nonZeroCount[i] tracks how many non-zero digits exist up to index i
        int[] nonZeroCount = new int[m + 1];

        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                numPrefix[i + 1] = (numPrefix[i] * 10 + (ch - '0')) % MOD;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                numPrefix[i + 1] = numPrefix[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }

        // Precompute powers of 10 and their modular inverses to optimize query loops
        long[] power10 = new long[m + 1];
        long[] invPower10 = new long[m + 1];
        power10[0] = 1;
        invPower10[0] = 1;
        long inv10 = modInverse(10);

        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
            invPower10[i] = (invPower10[i - 1] * inv10) % MOD;
        }

        // 3. Process each query in O(1) time
        int qLen = queries.length;
        int[] res = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // Extract the sum of digits in O(1)
            long currentSum = digitPrefix[r + 1] - digitPrefix[l];

            // If the range sums to 0, the resulting number value is 0
            if (currentSum == 0) {
                res[i] = 0;
                continue;
            }

            // Extract the modular value of non-zero characters in O(1)
            long totalLeftVal = numPrefix[l]; 
            long totalRightVal = numPrefix[r + 1];
            int nonZerosInRange = nonZeroCount[r + 1] - nonZeroCount[l];

            // Formula to strip out the left prefix prefix value:
            // segmentValue = (totalRightVal - totalLeftVal * 10^(nonZerosInRange)) % MOD
            long currentNumVal = (totalRightVal - (totalLeftVal * power10[nonZerosInRange]) % MOD + MOD) % MOD;

            // Compute final product securely modulo 10^9 + 7
            res[i] = (int) ((currentNumVal * currentSum) % MOD);
        }

        return res;
    }
}
