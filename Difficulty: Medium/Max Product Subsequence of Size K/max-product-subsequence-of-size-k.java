class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        long[][] max = new long[n + 1][k + 1];
        long[][] min = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(max[i], Long.MIN_VALUE);
            Arrays.fill(min[i], Long.MAX_VALUE);
        }

        max[0][0] = 1;
        min[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {

                max[i][j] = max[i - 1][j];
                min[i][j] = min[i - 1][j];

                if (j > 0) {
                    long x = arr[i - 1];

                    if (max[i - 1][j - 1] != Long.MIN_VALUE) {
                        max[i][j] = Math.max(max[i][j],
                                max[i - 1][j - 1] * x);

                        min[i][j] = Math.min(min[i][j],
                                max[i - 1][j - 1] * x);
                    }

                    if (min[i - 1][j - 1] != Long.MAX_VALUE) {
                        max[i][j] = Math.max(max[i][j],
                                min[i - 1][j - 1] * x);

                        min[i][j] = Math.min(min[i][j],
                                min[i - 1][j - 1] * x);
                    }
                }
            }
        }

        return (int) max[n][k];
    }
}