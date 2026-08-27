class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            int[] sorted = height.clone();
            Arrays.sort(sorted);

            for (int k = 1; k <= m; k++) {
                int h = sorted[m - k];
                maxArea = Math.max(maxArea, h * k);
            }
        }

        return maxArea;
    }
 }