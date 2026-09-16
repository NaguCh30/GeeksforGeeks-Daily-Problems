import java.util.Arrays;

class Solution {
    public int dominantPairs(int[] arr) {

        int n = arr.length;
        int mid = n / 2;

        // Sort the second half
        Arrays.sort(arr, mid, n);

        int count = 0;

        for (int i = 0; i < mid; i++) {

            int target = arr[i] / 5;

            // Find number of elements <= target
            int left = mid;
            int right = n;

            while (left < right) {

                int m = left + (right - left) / 2;

                if ((long) arr[i] >= 5L * arr[m]) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }

            count += left - mid;
        }

        return count;
    }
}