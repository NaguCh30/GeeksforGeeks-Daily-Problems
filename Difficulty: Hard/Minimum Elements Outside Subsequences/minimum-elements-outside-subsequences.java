class Solution {
    private int[][][] dp;

    private int solve(int idx, int incLast, int decLast, int[] arr) {
        if (idx == arr.length) {
            return 0;
        }

        if (dp[idx][incLast + 1][decLast + 1] != -1) {
            return dp[idx][incLast + 1][decLast + 1];
        }
        int ans = 1 + solve(idx + 1, incLast, decLast, arr);
        
        if (incLast == -1 || arr[idx] > arr[incLast]) {
            ans = Math.min(
                ans,
                solve(idx + 1, idx, decLast, arr)
            );
        }

        if (decLast == -1 || arr[idx] < arr[decLast]) {
            ans = Math.min(
                ans,
                solve(idx + 1, incLast, idx, arr)
            );
        }

        return dp[idx][incLast + 1][decLast + 1] = ans;
    }

    public int minCount(int[] arr) {
        int n = arr.length;

        dp = new int[n][n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, -1, -1, arr);
    }
}