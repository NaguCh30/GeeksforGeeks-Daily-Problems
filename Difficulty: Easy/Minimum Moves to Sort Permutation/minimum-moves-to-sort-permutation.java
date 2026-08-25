class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int[] dp = new int[n + 1];

        int maxLen = 1;

        for (int x = 1; x <= n; x++) {
            dp[x] = 1;

            if (x > 1 && pos[x - 1] < pos[x]) {
                dp[x] = dp[x - 1] + 1;
            }

            maxLen = Math.max(maxLen, dp[x]);
        }

        return n - maxLen;
    }
}