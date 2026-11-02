class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;

        int[] state = new int[n];
        int[] pathPosition = new int[n];

        Arrays.fill(pathPosition, -1);

        int maxSum = -1;

        for (int i = 0; i < n; i++) {

            if (state[i] != 0) {
                continue;
            }

            List<Integer> path = new ArrayList<>();
            int curr = i;

            while (curr != -1 && state[curr] == 0) {

                state[curr] = 1;
                pathPosition[curr] = path.size();

                path.add(curr);

                curr = edge[curr];
            }

            // Cycle detected in the current traversal
            if (curr != -1 && state[curr] == 1) {

                int cycleStart = pathPosition[curr];
                int sum = 0;

                for (int j = cycleStart; j < path.size(); j++) {
                    sum += path.get(j);
                }

                maxSum = Math.max(maxSum, sum);
            }

            // Mark all nodes in this path as completely processed
            for (int node : path) {
                state[node] = 2;
                pathPosition[node] = -1;
            }
        }

        return maxSum;
    }
}