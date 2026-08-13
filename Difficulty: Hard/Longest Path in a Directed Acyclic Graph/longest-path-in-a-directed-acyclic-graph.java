class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new int[]{v, w});
        }
        
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            
            if (dist[u] == Integer.MIN_VALUE) {
                continue;
            }
            
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                
                dist[v] = Math.max(dist[v], dist[u] + w);
            }
        }
        
        return dist;
    }
    
    private void dfs(int u, ArrayList<ArrayList<int[]>> adj,
                     boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        
        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            if (!visited[v]) {
                dfs(v, adj, visited, stack);
            }
        }
        
        stack.push(u);
    }
}