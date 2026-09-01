class Solution {
    public int palindromicStrings(int n, int k) {

        final long MOD = 1_000_000_007L;

        long ans = 0;
        long perm = 1; 

        for (int m = 0; m <= n / 2 && m <= k; m++) {

            if (2 * m + 1 <= n) {
                ans = (ans + perm * (k - m)) % MOD;
            }
            
            if (m > 0 && 2 * m <= n) {
                ans = (ans + perm) % MOD;
            }

            if (m < k) {
                perm = perm * (k - m) % MOD;
            }
        }

        return (int) ans;
    }
}