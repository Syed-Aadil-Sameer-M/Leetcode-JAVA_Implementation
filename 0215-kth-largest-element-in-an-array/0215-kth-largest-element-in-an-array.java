import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min heap with a capacity of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add the first k elements to the min heap
        for (int num : nums) {
            minHeap.offer(num);
            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min heap is the k-th largest element
        return minHeap.peek();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna