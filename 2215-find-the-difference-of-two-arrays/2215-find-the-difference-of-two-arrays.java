import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        List<Integer> diff1 = new ArrayList<>(set1);
        diff1.removeAll(set2);
        List<Integer> diff2 = new ArrayList<>(set2);
        diff2.removeAll(set1);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(diff1);
        ans.add(diff2);
        return ans;
    }
}
