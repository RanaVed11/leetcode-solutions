import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] count = new int[26];
        for (char c : p.toCharArray()) count[c - 'a']++;
        int left = 0, right = 0, needed = p.length();
        while (right < s.length()) {
            if (count[s.charAt(right) - 'a'] > 0) needed--;
            count[s.charAt(right) - 'a']--;
            right++;
            if (needed == 0) res.add(left);
            if (right - left == p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) needed++;
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }
}
