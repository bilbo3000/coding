public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     * 
     * O(n)
     */
    public int longestConsecutive(int[] num) {
        // merge cluster using a map 
        Map<Integer, Integer> m = new HashMap<>(); 
        int max = 0; 
        
        for (int key : num) {
            if (m.containsKey(key)) {
                continue; 
            }
            
            m.put(key, 1);
            max = Math.max(max, 1);
            
            if (m.containsKey(key - 1)) {
                int len1 = m.get(key - 1); 
                int len2 = m.get(key); 
                m.put(key - len1, len1 + len2);
                m.put(key + len2 - 1, len1 + len2);
                max = Math.max(max, len1 + len2);
            }
            
            if (m.containsKey(key + 1)) {
                int len1 = m.get(key); 
                int len2 = m.get(key + 1); 
                m.put(key - len1 + 1, len1 + len2);
                m.put(key + len2, len1 + len2);
                max = Math.max(max, len1 + len2);
            }
        }
        
        return max; 
    }
}
