class Solution {
    static final long MOD = 1000000007;

    static long countBT(int h) {

        if (h == 0 || h == 1) {
            return 1;
        }

        long[] dp = new long[h + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= h; i++) {

            dp[i] = (
                (dp[i - 1] * dp[i - 1]) % MOD
                + (2 * dp[i - 1] * dp[i - 2]) % MOD
            ) % MOD;
        }

        return dp[h];
    }
}