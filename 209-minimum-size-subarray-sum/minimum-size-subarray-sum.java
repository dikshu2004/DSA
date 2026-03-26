class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int minLen = Integer.MAX_VALUE;

        for(int high = 0; high < nums.length; high++){
            sum += nums[high];

            while(sum >= target){
                int len = high - low + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[low];
                low++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}