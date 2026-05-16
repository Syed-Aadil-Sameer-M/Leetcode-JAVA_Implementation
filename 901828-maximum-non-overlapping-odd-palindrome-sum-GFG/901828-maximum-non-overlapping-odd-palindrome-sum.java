class Solution {
    public int maxSum(String s) {
        int n = s.length();
        if (n < 2) return 0;

        // Step 1: Run Manacher's Algorithm for odd-length palindromes
        int[] P = new int[n]; 
        int c = 0, r = 0; // center and right boundary
        
        for (int i = 0; i < n; i++) {
            int mirror = 2 * c - i;
            if (i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }
            
            while (i - 1 - P[i] >= 0 && i + 1 + P[i] < n && s.charAt(i - 1 - P[i]) == s.charAt(i + 1 + P[i])) {
                P[i]++;
            }
            
            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }

        // Step 2: Build leftMax array
        // leftMax[i] = max odd palindrome length completely within s[0...i]
        int[] leftMax = new int[n];
        
        // Populate base lengths at their rightmost reachable ends
        for (int i = 0; i < n; i++) {
            int len = 2 * P[i] + 1;
            int rightEnd = i + P[i];
            leftMax[rightEnd] = Math.max(leftMax[rightEnd], len);
        }
        
        // Propagate values backward to handle smaller contained palindromes
        for (int i = n - 2; i >= 0; i--) {
            leftMax[i] = Math.max(leftMax[i], leftMax[i + 1] - 2);
        }
        
        // Take running prefix maximum
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i], leftMax[i - 1]);
        }

        // Step 3: Build rightMax array
        // rightMax[i] = max odd palindrome length completely within s[i...n-1]
        int[] rightMax = new int[n];
        
        // Populate base lengths at their leftmost reachable ends
        for (int i = 0; i < n; i++) {
            int len = 2 * P[i] + 1;
            int leftEnd = i - P[i];
            rightMax[leftEnd] = Math.max(rightMax[leftEnd], len);
        }
        
        // Propagate values forward to handle smaller contained palindromes
        for (int i = 1; i < n; i++) {
            rightMax[i] = Math.max(rightMax[i], rightMax[i - 1] - 2);
        }
        
        // Take running suffix maximum
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i], rightMax[i + 1]);
        }

        // Step 4: Find the split point that maximizes the sum
        int maxTotalSum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] > 0 && rightMax[i + 1] > 0) {
                maxTotalSum = Math.max(maxTotalSum, leftMax[i] + rightMax[i + 1]);
            }
        }

        return maxTotalSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna