public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     * 
     * Same idea as data stream median. 
     * 
     * O(n). 
     */
    public int median(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; 
            }
        });
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        
        int median = nums[0]; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= median) {
                maxHeap.add(nums[i]);
                
                if (maxHeap.size() > minHeap.size()) {
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
        }
        
        return median; 
    }
}

