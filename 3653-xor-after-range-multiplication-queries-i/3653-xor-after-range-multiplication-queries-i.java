class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1000000007;
        int n = nums.length;
        long xorResult = 0;
        
        for (int num : nums) {
            xorResult ^= num;
        }

        long[] multipliers = new long[n];
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            
            for (int idx = l; idx <= r; idx += k) {
                if (multipliers[idx] == 0) {
                    xorResult ^= nums[idx];
                }
                multipliers[idx] = (multipliers[idx] * v) % MOD;
               nums[idx] = (int)((1L * nums[idx] * v) % MOD);
               
                xorResult ^= nums[idx];
            }
        }

        return (int) xorResult;
    }
}
