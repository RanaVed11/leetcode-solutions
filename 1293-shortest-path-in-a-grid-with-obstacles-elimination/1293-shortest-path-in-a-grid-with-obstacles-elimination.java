import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return 0;
        }

        if (k >= m + n - 2) {
            return m + n - 2;
        }

        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int steps = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int rem = cur[2];

                if (r == m - 1 && c == n - 1) {
                    return steps;
                }

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    int nextRem = rem - grid[nr][nc];

                    if (nextRem >= 0 && !visited[nr][nc][nextRem]) {
                        visited[nr][nc][nextRem] = true;
                        q.offer(new int[]{nr, nc, nextRem});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}