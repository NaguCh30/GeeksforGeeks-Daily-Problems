class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = mat[n - 1][col];
        }

        for (int row = n - 2; row >= 0; row--) {

            for (int col = 0; col < n; col++) {

                int max = Integer.MIN_VALUE;

                for (int nextCol = 0; nextCol < n; nextCol++) {

                    if (nextCol != col) {
                        max = Math.max(max, dp[row + 1][nextCol]);
                    }
                }

                dp[row][col] = mat[row][col] + max;
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int col = 0; col < n; col++) {
            answer = Math.max(answer, dp[0][col]);
        }

        return answer;
    }
}