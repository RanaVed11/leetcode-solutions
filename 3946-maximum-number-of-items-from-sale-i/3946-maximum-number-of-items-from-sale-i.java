class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            int freeItems = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freeItems++;
                }
            }

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1 + freeItems);
            }
        }

        int ans = 0;

        for (int spent = 0; spent <= budget; spent++) {
            ans = Math.max(
                ans,
                dp[spent] + (budget - spent) / minPrice
            );
        }

        return ans;
    }
}