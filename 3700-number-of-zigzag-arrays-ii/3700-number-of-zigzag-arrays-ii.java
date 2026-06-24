class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        // State:
        // 0..m-1       -> UP[x]
        // m..2m-1      -> DOWN[x]
        int size = 2 * m;

        long[] base = new long[size];

        // Length = 2 initialization
        for (int x = 1; x <= m; x++) {
            base[x - 1] = x - 1;     // UP[x]
            base[m + x - 1] = m - x; // DOWN[x]
        }

        long[][] trans = new long[size][size];

        // UP_new[x] = sum(DOWN[y]) for y < x
        for (int x = 1; x <= m; x++) {
            int row = x - 1;

            for (int y = 1; y < x; y++) {
                trans[row][m + y - 1] = 1;
            }
        }

        // DOWN_new[x] = sum(UP[y]) for y > x
        for (int x = 1; x <= m; x++) {
            int row = m + x - 1;

            for (int y = x + 1; y <= m; y++) {
                trans[row][y - 1] = 1;
            }
        }

        long[][] power = matrixPower(trans, n - 2);

        long[] result = multiply(power, base);

        long ans = 0;
        for (long v : result) {
            ans = (ans + v) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;

                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        long[][] cur = mat;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, cur);
            }

            cur = multiply(cur, cur);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long aik = a[i][k];

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + aik * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}