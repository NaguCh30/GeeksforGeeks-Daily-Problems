
class Solution {

    private boolean isValid(String s, int[] p, int days) {
        int n = s.length();
        boolean[] removed = new boolean[n];

        // Mark positions replaced during the first 'days' days
        for (int i = 0; i < days; i++) {
            removed[p[i]] = true;
        }

        // Check adjacent characters
        for (int i = 0; i < n - 1; i++) {
            if (!removed[i] && !removed[i + 1]
                    && s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public int getMinimumDays(String s, int[] p) {
        int low = 0;
        int high = s.length();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(s, p, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
