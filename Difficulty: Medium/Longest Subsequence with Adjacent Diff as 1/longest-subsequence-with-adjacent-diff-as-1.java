class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int x : arr) {
            int prev = Math.max(
                dp.getOrDefault(x - 1, 0),
                dp.getOrDefault(x + 1, 0)
            );

            int curr = prev + 1;

            // Keep the best subsequence ending with x
            dp.put(x, Math.max(dp.getOrDefault(x, 0), curr));

            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}