class Solution {
    public int maxPackages(int[] arr, int totalTime) {

        int windowSum = 0;
        int k = Math.min(totalTime, arr.length);
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int max = windowSum;

        for (int i = k; i < arr.length; i++) {

            windowSum -= arr[i - totalTime];
            windowSum += arr[i];

            max = Math.max(max, windowSum);
        }

        return max;
    }
}