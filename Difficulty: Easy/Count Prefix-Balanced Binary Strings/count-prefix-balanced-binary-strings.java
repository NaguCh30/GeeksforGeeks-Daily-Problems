class Solution {
    static final long MOD = 1000000007L;

    public static int prefixStrings(int n) {
        long numerator = factorial(2 * n);
        long denominator = factorial(n);

        denominator = (denominator * factorial(n)) % MOD;
        denominator = (denominator * (n + 1)) % MOD;

        long result = (numerator * modInverse(denominator)) % MOD;

        return (int) result;
    }

    static long factorial(int x) {
        long result = 1;

        for (int i = 2; i <= x; i++) {
            result = (result * i) % MOD;
        }

        return result;
    }

    static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    static long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b /= 2;
        }

        return result;
    }
}