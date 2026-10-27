class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // Option 1: Leave the current character as a single
            int single = dp[i - 1] + 1;

            // Option 2: Pair the last two characters
            int pairScore = (s.charAt(i - 2) != s.charAt(i - 1)) ? 4 : 3;
            int pair = dp[i - 2] + pairScore;

            dp[i] = Math.max(single, pair);
        }

        return dp[n];
    }
}