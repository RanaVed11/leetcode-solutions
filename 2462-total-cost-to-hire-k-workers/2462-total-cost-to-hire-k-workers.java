class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> left = new PriorityQueue<>((a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        PriorityQueue<int[]> right = new PriorityQueue<>((a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int l = 0, r = n - 1;
        while (l < candidates && l <= r) {
            left.offer(new int[]{costs[l], l});
            l++;
        }
        while (r >= n - candidates && r >= l) {
            right.offer(new int[]{costs[r], r});
            r--;
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek()[0] <= right.peek()[0])) {
                int[] cur = left.poll();
                ans += cur[0];
                if (l <= r) {
                    left.offer(new int[]{costs[l], l});
                    l++;
                }
            } else {
                int[] cur = right.poll();
                ans += cur[0];
                if (l <= r) {
                    right.offer(new int[]{costs[r], r});
                    r--;
                }
            }
        }
        return ans;
    }
}
