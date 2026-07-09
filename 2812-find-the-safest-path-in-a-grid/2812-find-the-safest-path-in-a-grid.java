import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] d : dist) Arrays.fill(d, -1);
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni>=0 && nj>=0 && ni<n && nj<n && dist[ni][nj]==-1) {
                    dist[ni][nj] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        int lo = 0, hi = n*2;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (canReach(dist, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private boolean canReach(int[][] dist, int safeness) {
        int n = dist.length;
        if (dist[0][0] < safeness) return false;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0]==n-1 && cur[1]==n-1) return true;
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni>=0 && nj>=0 && ni<n && nj<n && !vis[ni][nj] && dist[ni][nj]>=safeness) {
                    vis[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return false;
    }
}
