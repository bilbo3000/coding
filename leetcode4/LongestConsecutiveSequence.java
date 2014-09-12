public class Solution {
    public int longestConsecutive(int[] num) {
        int max = 0; 
        int len = num.length; 
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < len; i++) {
            int key = num[i]; 
            
            if (!m.containsKey(key)) {
                m.put(key, 1);
                max = Math.max(max, 1); 
                
                if (m.containsKey(key - 1)) {
                    int newLength = m.get(key) + m.get(key - 1); 
                    max = Math.max(max, newLength); 
                    m.put(key + m.get(key) - 1, newLength);
                    m.put(key - m.get(key - 1), newLength); 
                }
                
                if (m.containsKey(key + 1)) {
                    int newLength = m.get(key) + m.get(key + 1); 
                    max = Math.max(max, newLength); 
                    m.put(key - m.get(key) + 1, newLength); 
                    m.put(key + m.get(key + 1), newLength); 
                }
            }
        }
        
        return max; 
    }
}
