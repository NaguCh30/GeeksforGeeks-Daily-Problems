class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int currentMin = arr[0];
        int minSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSum = Math.min(currentMin, minSum);
        }
        
        return minSum;
    }
}