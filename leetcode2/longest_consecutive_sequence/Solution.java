public class Solution {
    public int longestConsecutive(int[] num) {
        int n = num.length; 
        
        if (n == 0) return 0; 
        
        int result = 0; 
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < n; i++) {
            int x = num[i]; 
            if (m.containsKey(x)) continue; 
            m.put(x, 1); 
            result = Math.max(result, 1); 
            
            // x merge with previous cluster first 
            if (m.containsKey(x - 1)) {
                int length = m.get(x - 1) + 1; 
                m.put(x, length); 
                m.put(x - length + 1, length); 
                result = Math.max(result, length); 
            }
            
            // Then merge with behind cluster 
            if (m.containsKey(x + 1)) {
                int length1 = m.get(x);
                int length2 = m.get(x + 1); 
                m.put(x - length1 + 1, length1 + length2); 
                m.put(x + length2, length1 + length2); 
                result = Math.max(result, length1 + length2); 
            }
        }
        
        return result; 
    }
}
