class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] unsafe = new boolean[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    unsafe[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            unsafe[nr][nc] = true;
                        }
                    }
                }
            }
        }
        
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                queue.offer(new int[]{i, 0, 1});
                visited[i][0] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if (c == m - 1) {
                return distance;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !unsafe[nr][nc] &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, distance + 1});
                }
            }
        }

        return -1;
    }
}