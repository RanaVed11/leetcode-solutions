class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder sb = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inside = false;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                inside = true;
                key.setLength(0); // reset key
            } else if (c == ')') {
                inside = false;
                sb.append(map.getOrDefault(key.toString(), "?"));
            } else {
                if (inside) {
                    key.append(c);
                } else {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}
