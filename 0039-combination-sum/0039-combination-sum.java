import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (remain < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(res, temp, candidates, remain - candidates[i], i); // not i+1 because reuse allowed
            temp.remove(temp.size() - 1);
        }
    }
}
