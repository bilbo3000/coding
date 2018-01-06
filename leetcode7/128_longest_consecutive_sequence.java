/**
 * Given an array, find the length of the longest consecutive sequence. 
 * 
 * Because array may not sorted, thus need to use hash map here. 
 * Key is number from array and value is the sequence length use 
 * that item as bounary.
 * 
 * Note that for elements are not boundary, their value does not matter. 
 * 
 * For each item n, see if left (n - 1) and right (n + 1) is in the map. 
 * New length would be left + n + right. (left, right could be zero). 
 * Update left boundary of left and right broundary of right with new length. 
 * 
 * While walking through the list, keep track of the maximum length accordingly. 
 * 
 * Time: O(n), time to walk through the array; 
 * Space: O(n), hash map
 */ 
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>(); 
        int res = 0; 
        
        for (int num : nums) {
            if (!m.containsKey(num)) {
                int left = m.containsKey(num - 1) ? m.get(num - 1) : 0; 
                int right = m.containsKey(num + 1) ? m.get(num + 1) : 0; 
                int sum = left + 1 + right; 
                
                // Update result
                res = Math.max(res, sum);
                
                // The length of sequence num is in
                m.put(num, sum);
                
                // Update left and right boundary
                m.put(num - left, sum);
                m.put(num + right, sum);
            }
        }
        
        return res; 
    }
}
