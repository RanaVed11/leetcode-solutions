import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            result.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] + 1 < nums2.length) {
                heap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }
        return result;
    }
}
