class Geeks {
    // Function to check if two numbers in array have sum equal to the given sum.
    public static int sumExists(int arr[], int sum) {
        // Create a HashSet to store the elements we have seen so far
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        
        for (int num : arr) {
            // Calculate the required complement to reach the target sum
            int complement = sum - num;
            
            // If the complement is already in the set, we found the pair
            if (seen.contains(complement)) {
                return 1;
            }
            
            // Otherwise, add the current number to the set
            seen.add(num);
        }
        
        // If no such pair is found after checking the entire array
        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna