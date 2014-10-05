public class Solution {
    public int longestConsecutive(int[] num) {
        int result = 0; 
        int len = num.length; 
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < len; i++) {
            int key = num[i]; 
            
            if (!m.containsKey(key)) {
                m.put(key, 1); 
                result = Math.max(result, 1); 
                
                if (m.containsKey(key - 1)) {
                    int temp = m.get(key - 1) + m.get(key); 
                    m.put(key, temp);
                    m.put(key - temp + 1, temp); 
                    result = Math.max(result, temp); 
                }
                
                if (m.containsKey(key + 1)) {
                    int temp = m.get(key + 1) + m.get(key); 
                    m.put(key - m.get(key) + 1, temp);
                    m.put(key + m.get(key + 1), temp); 
                    result = Math.max(result, temp); 
                }
            }
        }
        
        return result; 
    }
}
