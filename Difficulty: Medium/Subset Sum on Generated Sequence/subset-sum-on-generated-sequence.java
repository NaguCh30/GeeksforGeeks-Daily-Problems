class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) {
            return true;
        }

        if (s > x) {
            return false;
        }

        boolean[] dp = new boolean[x + 1];
        dp[0] = true;

        dp[s] = true;

        long sum = s;

        for (int a : arr) {
            long next = sum + a;

            if (next > x) {
                break;
            }

            int value = (int) next;

            for (int j = x; j >= value; j--) {
                dp[j] = dp[j] || dp[j - value];
            }

            sum += next;
        }

        return dp[x];
    }
}