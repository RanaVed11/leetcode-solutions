import java.util.*;

class Solution {
    public int maxProduct(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        int len = digits.length;
        return (digits[len - 1] - '0') * (digits[len - 2] - '0');
    }
}
