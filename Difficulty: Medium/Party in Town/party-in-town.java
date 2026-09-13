class Solution {

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        dist[start] = 0;

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj.get(current - 1)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);

                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, dist[farthestNode]};
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {

        int[] first = bfs(adj, 1);
        int endpoint = first[0];

        int[] second = bfs(adj, endpoint);
        int diameter = second[1];

        return (diameter + 1) / 2;
    }
}