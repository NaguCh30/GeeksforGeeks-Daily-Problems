class Solution {
    public int pairCount(int x, int y) {

        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int distinctPrimeFactors = 0;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                distinctPrimeFactors++;

                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            distinctPrimeFactors++;
        }

        return 1 << distinctPrimeFactors;
    }
}