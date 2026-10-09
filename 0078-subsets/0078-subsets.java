class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totSubsets = (1 << n);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < totSubsets; i++) {
            List<Integer> currSubset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currSubset.add(nums[j]);
                }
            }
            res.add(currSubset);
        }
        
        return res;
    }
}