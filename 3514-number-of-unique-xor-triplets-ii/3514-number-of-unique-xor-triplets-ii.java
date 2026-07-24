class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048; // since nums[i] <= 1500 < 2^11
        
        boolean[] seen = new boolean[MAX];
        for (int v : nums) seen[v] = true;
        
        int m = 0;
        int[] vals = new int[MAX];
        for (int v = 0; v < MAX; v++) {
            if (seen[v]) vals[m++] = v;
        }
        
        // Step 1: all reachable XOR-of-two-values
        boolean[] pairXor = new boolean[MAX];
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                pairXor[vals[i] ^ vals[j]] = true;
            }
        }
        
        // Step 2: combine with a third value
        boolean[] tripleXor = new boolean[MAX];
        for (int s = 0; s < MAX; s++) {
            if (!pairXor[s]) continue;
            for (int i = 0; i < m; i++) {
                tripleXor[s ^ vals[i]] = true;
            }
        }
        
        int count = 0;
        for (boolean b : tripleXor) {
            if (b) count++;
        }
        return count;
    }
}