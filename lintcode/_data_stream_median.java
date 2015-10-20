public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     * 
     * Maintain maxHeap (left part), median (hold the median), and minHeap
     * (right part). If incoming number is less or equal to median, add 
     * the number to left maxHeap. If incoming number is greater than median, 
     * add the number to right minHeap. If either heap becomes too large, 
     * rotate from one heap to the other heap via median. 
     * 
     * O(n). 
     */
    public int[] medianII(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; 
            }
        }); 
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10);
        int len = nums.length; 
        int[] out = new int[len]; 
        int median = nums[0]; 
        out[0] = median;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] <= median) {
                maxHeap.add(nums[i]);
                
                if (maxHeap.size() - minHeap.size() >= 1) {
                    minHeap.add(median);
                    median = maxHeap.poll();
                }
            } else {
                minHeap.add(nums[i]);
                
                if (minHeap.size() - maxHeap.size() >= 2) {
                    maxHeap.add(median);
                    median = minHeap.poll(); 
                }
            }
            
            out[i] = median; 
        }
        
        return out; 
    }
}
