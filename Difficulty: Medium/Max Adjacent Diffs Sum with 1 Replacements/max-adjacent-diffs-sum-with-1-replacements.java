class Solution {
     public int maxDiffSum(int[] arr) {

         int n = arr.length;

         int[][] dp = new int[n][2];


         dp[0][0] = 0;
         dp[0][1] = 0;

         for (int i = 1; i < n; i++) {
             
             dp[i][0] = Math.max(
                 dp[i - 1][0] + Math.abs(1 - 1),
                 dp[i - 1][1] + Math.abs(arr[i - 1] - 1)
             );

             dp[i][1] = Math.max(
                 dp[i - 1][0] + Math.abs(1 - arr[i]),
                 dp[i - 1][1] + Math.abs(arr[i - 1] - arr[i])
             );
         }

         return Math.max(dp[n - 1][0], dp[n - 1][1]);
     }
 }