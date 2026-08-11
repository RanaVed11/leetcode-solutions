class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        
        // Find end index of the longest sequential prefix
        int i = 0;
        while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
            i++;
        }
        
        // Sum of that prefix
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += nums[j];
        }
        
        // Find smallest missing value >= sum
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        while (set.contains(sum)) {
            sum++;
        }
        
        return sum;
    }
}