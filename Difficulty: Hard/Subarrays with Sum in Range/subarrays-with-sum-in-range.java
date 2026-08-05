import java.util.*;

class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        int n = arr.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // Coordinate compression
        long[] vals = new long[n + 1];
        for (int i = 0; i <= n; i++) vals[i] = prefix[i];
        Arrays.sort(vals);

        Fenwick bit = new Fenwick(vals.length);

        long ans = 0;

        // Insert prefix sum = 0
        bit.add(index(vals, prefix[0]), 1);

        for (int i = 1; i <= n; i++) {
            long low = prefix[i] - r;
            long high = prefix[i] - l;

            int right = upperBound(vals, high);
            int left = lowerBound(vals, low);

            ans += bit.query(right) - bit.query(left);

            bit.add(index(vals, prefix[i]), 1);
        }

        return (int) ans;
    }

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    // 1-based index for exact value
    private int index(long[] arr, long x) {
        return lowerBound(arr, x) + 1;
    }

    // First index >= target
    private int lowerBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    // First index > target
    private int upperBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}