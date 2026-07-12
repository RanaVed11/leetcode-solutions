class Solution {
    private int maxLen = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // assume last move was left
        dfs(root, false, 0); // assume last move was right
        return maxLen;
    }
    
    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;
        
        maxLen = Math.max(maxLen, length);
        
        if (isLeft) {
            dfs(node.left, false, length + 1);  // continue zigzag
            dfs(node.right, true, 1);           // restart zigzag
        } else {
            dfs(node.right, true, length + 1);  // continue zigzag
            dfs(node.left, false, 1);           // restart zigzag
        }
    }
}
