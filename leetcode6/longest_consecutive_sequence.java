/**
 * In the given array, find the longest consecutive number sequence. 
 * The idea was to use "merge cluster". Maintain a map where the value 
 * is the length of the cluster that starts or ends with the key element. 
 * Note that the value for middle elements do not matter. For each element, 
 * if already in map, ignore. Then put the element into the map with length, 
 * meaning itself is a cluster of length 1. Then try to merge with its 
 * immediate before and immediate after cluster. Update their end points 
 * accordingly. While work through the array, keep updating the max length. 
 */ 
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>(); 
        int max = 0; 
        
        for (int item : nums) {
            if (m.containsKey(item)) {
                continue; 
            }
            
            m.put(item, 1); 
            max = Math.max(max, 1);
            
            // Merge in previous cluster 
            if (m.containsKey(item - 1)) {
                int prevLen = m.get(item - 1); 
                int currLen = m.get(item); 
                m.put(item + currLen - 1, prevLen + currLen); 
                m.put(item - prevLen, prevLen + currLen);
                max = Math.max(max, prevLen + currLen); 
            }
            
            // Merge in after cluster
            if (m.containsKey(item + 1)) {
                int afterLen = m.get(item + 1); 
                int currLen = m.get(item); 
                m.put(item - currLen + 1, afterLen + currLen); 
                m.put(item + afterLen, afterLen + currLen);
                max = Math.max(max, afterLen + currLen); 
            }
        }
        
        return max; 
    }
}
