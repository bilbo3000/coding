public class Solution {
    public int longestConsecutive(int[] num) {
        int len = num.length; 
        int max = 0; 
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < len; i++) {
            if (!m.containsKey(num[i])) {
                m.put(num[i], 1);
                
                // Merge with left 
                int leftLen = 0; 
                
                if (m.containsKey(num[i] - 1)) {
                    leftLen = m.get(num[i] - 1); 
                    m.put(num[i], m.get(num[i]) + leftLen);
                }
                
                // Merge with left 
                int rightLen = 0; 
                
                if (m.containsKey(num[i] + 1)) {
                    rightLen = m.get(num[i] + 1); 
                    m.put(num[i], m.get(num[i]) + rightLen); 
                }
                
                m.put(num[i] - leftLen, m.get(num[i])); 
                m.put(num[i] + rightLen, m.get(num[i])); 
                
                max = Math.max(max, m.get(num[i])); 
            }
        }
        
        return max; 
    }
}
