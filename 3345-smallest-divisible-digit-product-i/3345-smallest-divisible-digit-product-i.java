class Solution {
    public int smallestNumber(int n, int t) {
        for (int num = n; ; num++) {
            if (digitProduct(num) % t == 0) {
                return num;
            }
        }
    }

    private int digitProduct(int num) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }
}