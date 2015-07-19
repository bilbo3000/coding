/**
 * Find the kth largest number in an array. 
 * The min-heap approach. Iterating through the input array and insert the element 
 * into a heap with max size k. In the end, the top element would be the Kth 
 * largest element in the array. 
 * Note that we can use priority queue to implement a heap. Just need to maintain 
 * the queue size to be k. 
 */ 
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a < b) {
                    return -1; 
                } else if (a == b) {
                    return 0; 
                } else {
                    return 1; 
                }
            }
        }); 
        
        for (int item : nums) {
            if (pq.size() < k) {
                pq.add(item); 
            } else {
                if (item > pq.peek()) {
                    // Need to enqueue
                    pq.remove(); 
                    pq.add(item); 
                }
            }
        }
        
        return pq.peek(); 
    }
}
