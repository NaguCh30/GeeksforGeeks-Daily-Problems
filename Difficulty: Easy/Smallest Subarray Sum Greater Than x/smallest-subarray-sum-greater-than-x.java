class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        // code here
        int l = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        
        for (int r = 0; r < arr.length; r++) {
            
            sum += arr[r];
            
            while (sum > x) {
                len = Math.min(len, r- l + 1);
                sum -= arr[l++];
            }
            
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}