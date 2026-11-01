class Solution {
    public int maximumSubarray(int[] arr) {

        int withoutSquare = arr[0];
        int withSquare = arr[0] * arr[0];

        int ans = Math.max(withoutSquare, withSquare);

        for (int i = 1; i < arr.length; i++) {

            int x = arr[i];

            int prevWithout = withoutSquare;
            int prevWith = withSquare;

            withoutSquare = Math.max(x, prevWithout + x);

            withSquare = Math.max(
                x * x,
                Math.max(prevWith + x, prevWithout + x * x)
            );

            ans = Math.max(ans, Math.max(withoutSquare, withSquare));
        }

        return ans;
    }
}