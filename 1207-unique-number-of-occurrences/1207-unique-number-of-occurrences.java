import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) freq.put(n, freq.getOrDefault(n, 0) + 1);
        Set<Integer> set = new HashSet<>(freq.values());
        return set.size() == freq.size();
    }
}
