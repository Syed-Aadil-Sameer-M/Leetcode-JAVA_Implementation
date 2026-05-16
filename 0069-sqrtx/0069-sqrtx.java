class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x; // Return x for 0 and 1
        }

        long left = 2, right = x / 2; // Use long to avoid overflow
        while (left <= right) {
            long mid = left + (right - left) / 2; // Avoid potential overflow

            if (mid * mid == x) {
                return (int) mid; // Found exact square root
            } else if (mid * mid < x) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }

        return (int) right; // Right is the largest integer where right * right <= x
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna