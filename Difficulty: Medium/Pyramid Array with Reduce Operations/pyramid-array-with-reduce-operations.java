class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        // Maximum possible increasing slope ending at i
        left[0] = Math.min(arr[0], 1);

        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        // Maximum possible decreasing slope starting at i
        right[n - 1] = Math.min(arr[n - 1], 1);

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long total = 0;

        for (int x : arr) {
            total += x;
        }

        long maxPyramidSum = 0;

        for (int i = 0; i < n; i++) {

            int h = Math.min(left[i], right[i]);

            // Number of elements on each side including peak
            long sideSum = (long) h * (h + 1) / 2;

            // Peak counted twice, so subtract it once
            long pyramidSum = 2 * sideSum - h;

            maxPyramidSum = Math.max(maxPyramidSum, pyramidSum);
        }

        return (int) (total - maxPyramidSum);
    }
}