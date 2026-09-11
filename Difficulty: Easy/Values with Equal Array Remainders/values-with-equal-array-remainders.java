class Solution {
    public int sameMod(int[] arr) {
        int g = 0;

        // GCD of differences from the first element
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[0]));
        }

        // All elements are equal
        if (g == 0) {
            return -1;
        }

        // Count positive divisors of g
        int count = 0;

        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++; // i

                if (i != g / i) {
                    count++; // g/i
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}