class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node.left == null || node.right == null) queue.offer(node);
            if (node.left != null) bfs.offer(node.left);
            if (node.right != null) bfs.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v);
        if (parent.left == null) parent.left = node;
        else {
            parent.right = node;
            queue.poll();
        }
        queue.offer(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
