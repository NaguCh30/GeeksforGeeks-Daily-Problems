class Solution {
    public String compress(String s) {
        int n = s.length();
        if (n == 0) return "";

        int[] z = zFunction(s);

        int[] encLen = new int[n + 1];
        int[] parent = new int[n + 1];
        char[] op = new char[n + 1];
        String[] memo = new String[n + 1];

        parent[0] = -1;
        memo[0] = "";

        for (int i = 1; i <= n; i++) {
            int bestLen = encLen[i - 1] + 1;
            int bestParent = i - 1;
            char bestOp = s.charAt(i - 1);

            if (i % 2 == 0) {
                int half = i / 2;
                if (half >= 1 && z[half] >= half) {
                    int doubleLen = encLen[half] + 1;
                    if (doubleLen < bestLen) {
                        bestLen = doubleLen;
                        bestParent = half;
                        bestOp = '*';
                    } else if (doubleLen == bestLen) {
                        String a = getDp(half, parent, op, memo);
                        String b = getDp(i - 1, parent, op, memo);
                        if ((a + '*').compareTo(b + s.charAt(i - 1)) < 0) {
                            bestParent = half;
                            bestOp = '*';
                        }
                    }
                }
            }

            encLen[i] = bestLen;
            parent[i] = bestParent;
            op[i] = bestOp;
        }

        return getDp(n, parent, op, memo);
    }

    private String getDp(int target, int[] parent, char[] op, String[] memo) {
        if (memo[target] != null) return memo[target];

        Deque<Integer> pending = new ArrayDeque<>();
        int cur = target;
        while (memo[cur] == null) {
            pending.push(cur);
            cur = parent[cur];
        }
        while (!pending.isEmpty()) {
            int idx = pending.pop();
            memo[idx] = memo[parent[idx]] + op[idx];
        }
        return memo[target];
    }

    private int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
            if (i + z[i] > r) { l = i; r = i + z[i]; }
        }
        return z;
    }
}