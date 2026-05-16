import java.util.Stack;

class Solution {
    public boolean has132Pattern(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        // num3 represents the '2' in the 132 pattern (arr[k])
        int num3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // If we find an element smaller than num3, 
            // then arr[i] < num3 (arr[k]) < stack.peek() (arr[j])
            if (arr[i] < num3) {
                return true;
            }

            // If current element is greater than stack top,
            // it qualifies as '3' (arr[j]), so we update '2' (arr[k])
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                num3 = stack.pop();
            }

            // Push current element as a potential '3' or '2'
            stack.push(arr[i]);
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna