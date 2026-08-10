class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        // dp[0] = false: player to move with 0 stones has already lost (no move possible)
        
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break; // found a winning move, no need to check further
                }
            }
        }
        
        return dp[n];
    }
}