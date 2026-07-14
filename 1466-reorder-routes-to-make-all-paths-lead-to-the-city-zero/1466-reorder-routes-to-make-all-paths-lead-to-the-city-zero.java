class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); // original direction
            graph.get(conn[1]).add(new int[]{conn[0], 0}); // reverse direction
        }
        
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    
    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;
        for (int[] edge : graph.get(node)) {
            int next = edge[0], needsReverse = edge[1];
            if (!visited[next]) {
                changes += needsReverse + dfs(next, graph, visited);
            }
        }
        return changes;
    }
}
