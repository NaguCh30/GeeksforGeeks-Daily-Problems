class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int m = (n + 1) / 2;
        int INF = 1_000_000_000;

        int[] dp = new int[26];
        int[] ndp = new int[26];

        // Initialize the first mirrored pair
        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        if (first != '?' && last != '?' && first != last) {
            return -1;
        }

        for (int c = 0; c < 26; c++) {
            char ch = (char) ('a' + c);
            if ((first == '?' || first == ch) &&
                (last == '?' || last == ch)) {
                dp[c] = 0;
            } else {
                dp[c] = INF;
            }
        }

        // Process each subsequent mirrored pair
        for (int i = 1; i < m; i++) {
            char left = s.charAt(i);
            char right = s.charAt(n - 1 - i);

            if (left != '?' && right != '?' && left != right) {
                return -1;
            }

            for (int c = 0; c < 26; c++) {
                ndp[c] = INF;
                char ch = (char) ('a' + c);

                if ((left != '?' && left != ch) ||
                    (right != '?' && right != ch)) {
                    continue;
                }

                for (int p = 0; p < 26; p++) {
                    if (dp[p] == INF) continue;

                    int cost = dp[p] + 2 * Math.abs(ch - (char) ('a' + p));
                    ndp[c] = Math.min(ndp[c], cost);
                }
            }

            int[] temp = dp;
            dp = ndp;
            ndp = temp;
        }

        int ans = INF;
        for (int c = 0; c < 26; c++) {
            ans = Math.min(ans, dp[c]);
        }

        return ans;
    }
}
