class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int i = 0, j = 0;
        int n = s1.length();

        while (i < n && j < n) {

            // Skip empty positions
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }

            while (j < n && s2.charAt(j) == '#') {
                j++;
            }

            // Both strings have no more A or B
            if (i == n || j == n) {
                return i == n && j == n;
            }

            // Characters must appear in the same order
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }

            // A can only move left
            if (s1.charAt(i) == 'A' && i < j) {
                return false;
            }

            // B can only move right
            if (s1.charAt(i) == 'B' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}