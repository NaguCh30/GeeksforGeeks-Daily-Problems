class Solution {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        long union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                return 0;
            }

            long newPaths = (long) size[rootU] * size[rootV];

            if (size[rootU] < size[rootV]) {
                int temp = rootU;
                rootU = rootV;
                rootV = temp;
            }

            parent[rootV] = rootU;
            size[rootU] += size[rootV];

            return newPaths;
        }
    }

    public ArrayList<Integer> maximumWeight(
            int n, int[][] edges, int[] queries) {

        // Sort edges by weight
        Arrays.sort(edges, (a, b) ->
            Integer.compare(a[2], b[2])
        );

        // Store queries with their original indices
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        DSU dsu = new DSU(n);

        long[] ans = new long[queries.length];

        long totalPaths = 0;
        int edgeIndex = 0;

        for (int i = 0; i < queries.length; i++) {

            int limit = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            // Process all edges with weight <= query
            while (edgeIndex < edges.length &&
                   edges[edgeIndex][2] <= limit) {

                totalPaths += dsu.union(
                    edges[edgeIndex][0],
                    edges[edgeIndex][1]
                );

                edgeIndex++;
            }

            ans[originalIndex] = totalPaths;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (long value : ans) {
            result.add((int) value);
        }

        return result;
    }
}
