class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int[] dp = new int[n + 1];

        // Day 0
        dp[1] = Math.max(h[0], l[0]);

        for (int i = 2; i <= n; i++) {
            // Do nothing
            dp[i] = dp[i - 1];

            // Perform low-effort task
            dp[i] = Math.max(dp[i], dp[i - 1] + l[i - 1]);

            // Perform high-effort task
            // Previous day must have had no task
            dp[i] = Math.max(dp[i], dp[i - 2] + h[i - 1]);
        }

        return dp[n];
    }
}