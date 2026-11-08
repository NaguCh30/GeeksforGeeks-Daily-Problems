class Solution {
    public int minTime(int n, int s1, int s2) {
        long low = 0;
        long high = (long) n * Math.min(s1, s2);
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long docsScanned = (mid / s1) + (mid / s2);

            if (docsScanned >= n) {
                ans = mid;         
                high = mid - 1;    
            } else {
                low = mid + 1;     
            }
        }

        return (int) ans;
    }
}
