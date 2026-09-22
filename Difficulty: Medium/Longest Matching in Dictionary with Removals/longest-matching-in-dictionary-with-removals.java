class Solution {
    public String findLongestWord(String s, List<String> d) {

        String ans = "";

        for (String str : d) {

            // Cannot possibly be better
            if (str.length() < ans.length()) {
                continue;
            }

            // Same length, but lexicographically not better
            if (str.length() == ans.length() &&
                str.compareTo(ans) >= 0) {
                continue;
            }

            int i = 0;
            int j = 0;

            while (i < s.length() && j < str.length()) {

                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }

                i++;
            }

            if (j == str.length()) {
                ans = str;
            }
        }

        return ans;
    }
}