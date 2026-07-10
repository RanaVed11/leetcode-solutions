import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                res[i] = -1.0;
            } else if (src.equals(dst)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(src, dst, graph, new HashSet<>(), 1.0);
            }
        }
        return res;
    }
    
    private double dfs(String src, String dst, Map<String, Map<String, Double>> graph, Set<String> visited, double product) {
        if (src.equals(dst)) return product;
        visited.add(src);
        
        for (Map.Entry<String, Double> nei : graph.get(src).entrySet()) {
            if (!visited.contains(nei.getKey())) {
                double ans = dfs(nei.getKey(), dst, graph, visited, product * nei.getValue());
                if (ans != -1.0) return ans;
            }
        }
        return -1.0;
    }
}
