class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 1, maxLevel = 1;
        int maxSum = root.val;
        
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }
        
        return maxLevel;
    }
}
