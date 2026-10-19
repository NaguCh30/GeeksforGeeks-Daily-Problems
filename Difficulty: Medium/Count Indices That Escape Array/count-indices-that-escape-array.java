
class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        // 0 = unvisited, 1 = visiting, 2 = good, 3 = bad
        int[] state = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dfs(i, arr, state)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int i, int[] arr, int[] state) {
        int n = arr.length;

        // Jump goes outside the array
        if (i < 0 || i >= n) {
            return true;
        }

        // Already determined
        if (state[i] == 2) return true;
        if (state[i] == 3) return false;

        // Cycle detected
        if (state[i] == 1) return false;

        // Zero jump is bad
        if (arr[i] == 0) {
            state[i] = 3;
            return false;
        }

        state[i] = 1;

        boolean good = dfs(i + arr[i], arr, state);

        state[i] = good ? 2 : 3;
        return good;
    }
}
