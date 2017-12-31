/**
 * Given two arrays nums1 and nums2. For each element in nums1, find its
 * next greater element in nums2. 
 * 
 * Core idea is to use a stack to keep a decreasing sequence. Each incoming
 * element will pop previous smaller elements and becomes their next larger element. 
 * Perform this operation for nums2 and store the results of each pair in a map. 
 * Then go through nums1 and look up results from the map. Set -1 if no results 
 * found in map. 
 * 
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();  // A map from x in nums2 to its next greater number
        Stack<Integer> s = new Stack<>();  // A stack keeps a decreasing sequence of x in nums2
        
        for (int item : nums2) {
            if (s.isEmpty()) {
                s.push(item);
            } else {
                while (!s.isEmpty() && s.peek() < item) {
                    int temp = s.pop(); 
                    m.put(temp, item);
                }
                
                s.push(item);
            }
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            if (!m.containsKey(nums1[i])) {
                res[i] = -1; 
            } else {
                res[i] = m.get(nums1[i]);
            }
        }
        
        return res; 
    }
}
