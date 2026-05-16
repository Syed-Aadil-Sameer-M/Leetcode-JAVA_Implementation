class Solution {
    public int minParentheses(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;
        
        // Using a primitive loop with charAt() avoids the memory allocation of s.toCharArray()
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                closeNeeded++;
            } else {
                if (closeNeeded > 0) {
                    closeNeeded--;
                } else {
                    openNeeded++;
                }
            }
        }
        
        return openNeeded + closeNeeded;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna