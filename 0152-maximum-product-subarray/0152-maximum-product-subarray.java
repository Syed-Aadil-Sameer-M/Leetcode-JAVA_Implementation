class Solution {
    public int maxProduct(int[] nums) {
        // Edge case: if array is empty, return 0 (though problem constraints usually guarantee at least one element)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Initialize the maximum and minimum products ending at the current position.
        // Both start as the first element because a subarray must contain at least one number.
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        // Iterate from the second element onward.
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            
            // When cur is negative, max and min swap roles after multiplication.
            // Store previous maxSoFar before updating it.
            int prevMax = maxSoFar;
            
            // Compute the new max and min products ending at index i.
            maxSoFar = Math.max(cur, Math.max(prevMax * cur, minSoFar * cur));
            minSoFar = Math.min(cur, Math.min(prevMax * cur, minSoFar * cur));
            
            // Update the global maximum product found so far.
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna