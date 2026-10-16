class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        int prefixMax = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, arr[i]);

            if (arr[i] == prefixMax && arr[i] == suffixMin[i]) {
                count++;
            }
        }

        return count;
    }
}
