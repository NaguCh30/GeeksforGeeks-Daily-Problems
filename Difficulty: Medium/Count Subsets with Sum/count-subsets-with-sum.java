
class Solution {
    public int perfectSum(int[] arr, int target) {

        int[] dp = new int[target + 1];
        
        dp[0] = 1;

        for (int num : arr) {

            for (int sum = target; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[target];
    }
}