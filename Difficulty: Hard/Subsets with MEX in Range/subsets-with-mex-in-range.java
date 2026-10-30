
class Solution {
    static final long MOD = 1_000_000_007L;

    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;

        // Step 1: Frequency array
        int[] freq = new int[n + 1];

        for (int num : arr) {
            if (num >= 0 && num <= n) {
                freq[num]++;
            }
        }

        // Step 2: Precompute powers of 2
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // Step 3: Calculate counts for each MEX
        long requiredWays = 1;
        int prefixCount = 0;
        long ans = 0;

        int start = Math.max(0, l);
        int end = Math.min(n, r);

        for (int k = 0; k <= end; k++) {

            // Include occurrences of k in excluded count
            prefixCount += freq[k];

            // Count subsets having exact MEX = k
            if (k >= start) {
                long ways = (requiredWays * 
                             pow2[n - prefixCount]) % MOD;

                ans = (ans + ways) % MOD;
            }

            // Prepare requiredWays for next MEX
            requiredWays = (requiredWays *
                           (pow2[freq[k]] - 1 + MOD)) % MOD;
        }

        return (int) ans;
    }
}
