import java.util.Arrays;

class Solution {
    public int findMinDiff(int[] arr, int m) {
        int n = arr.length;

        // If there are no chocolates or students
        if (m == 0 || n == 0) {
            return 0;
        }

        // Sort the array
        Arrays.sort(arr);

        // If there are fewer packets than students
        if (n < m) {
            return -1; // Not enough packets
        }

        int minDiff = Integer.MAX_VALUE;

        // Find the minimum difference
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna