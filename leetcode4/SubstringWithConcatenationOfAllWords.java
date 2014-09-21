public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>(); 
        Map<String, Integer> m = new HashMap<String, Integer>(); 
        
        if (L.length == 0) {
            return result; 
        }
        
        int len = L[0].length(); 

        for (String s : L) {
            if (m.containsKey(s)) {
                m.put(s, m.get(s) + 1); 
            } else {
                m.put(s, 1); 
            }
        }
        
        for (int i = 0; i <= S.length() - L.length * len; i++) {
            Map<String, Integer> temp = new HashMap<String, Integer>(m); 
            check(i, S, L, temp, result, len); 
        }
        
        return result; 
    }
    
    private void check(int index, String S, String[] L, Map<String, Integer> m, List<Integer> result, int len) {
        for (int i = 0; i < L.length; i++) {
            String key = S.substring(index + len * i, index + len * (i + 1)); 
            
            if (!m.containsKey(key) || m.get(key) <= 0) {
                return; 
            } else {
                m.put(key, m.get(key) - 1); 
            }
        }
        
        result.add(index); 
    }
}
