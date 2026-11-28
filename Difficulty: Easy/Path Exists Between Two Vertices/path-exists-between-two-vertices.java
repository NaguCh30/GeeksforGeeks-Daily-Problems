class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {

        int V = adj.size();

        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.offer(u);
        visited[u] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();

            if (curr == v) {
                return true;
            }

            for (int neighbour : adj.get(curr)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

        return false;
    }
}