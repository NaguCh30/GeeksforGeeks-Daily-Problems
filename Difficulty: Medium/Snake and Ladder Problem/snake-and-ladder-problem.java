
class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int N = n * n;

        int[] jump = new int[N + 1];

        Arrays.fill(jump, -1);

        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[N + 1];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int cell = current[0];
            int throwsCount = current[1];

            if (cell == N) {
                return throwsCount;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cell + dice;

                if (next > N) {
                    continue;
                }

                if (jump[next] != -1) {
                    next = jump[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, throwsCount + 1});
                }
            }
        }

        return -1;
    }
}