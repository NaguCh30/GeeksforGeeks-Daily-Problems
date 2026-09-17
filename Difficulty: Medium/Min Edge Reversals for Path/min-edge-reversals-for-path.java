class Solution {

    static class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {

        // Adjacency list
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Original direction: no reversal
            graph.get(u).add(new Pair(v, 0));

            // Reverse direction: one reversal
            graph.get(v).add(new Pair(u, 1));
        }

        // Minimum cost from src to every node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> deque = new ArrayDeque<>();

        dist[src] = 0;
        deque.addFirst(src);

        while (!deque.isEmpty()) {

            int u = deque.removeFirst();

            for (Pair edge : graph.get(u)) {

                int v = edge.node;
                int weight = edge.cost;

                if (dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;

                    if (weight == 0) {
                        deque.addFirst(v);
                    } else {
                        deque.addLast(v);
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}