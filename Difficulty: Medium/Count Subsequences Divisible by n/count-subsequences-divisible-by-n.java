class Solution {
    int countSubsequences(String s, int n) {
        final long MOD = 1_000_000_007L;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            // Copy current dp so we don't reuse this digit multiple times
            long[] next = dp.clone();
            
            next[digit % n]++;

            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int newRem = (r * 10 + digit) % n;
                    next[newRem] = (next[newRem] + dp[r]) % MOD;
                }
            }

            dp = next;
        }

        return (int) (dp[0] % MOD);
    }
}