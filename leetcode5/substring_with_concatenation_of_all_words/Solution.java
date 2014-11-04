public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>(); 
        Map<String, Integer> m = new HashMap<String, Integer>(); 
        
        if (S.length() == 0 || L.length == 0) {
            return result; 
        }
        
        for (String item : L) {
            if (!m.containsKey(item)) {
                m.put(item, 1); 
            } else {
                m.put(item, m.get(item) + 1); 
            }
        }
        
        int len1 = S.length(); 
        int len2 = L[0].length(); 
        
        for (int i = 0; i <= len1 - L.length * len2; i++) {
            Map<String, Integer> temp = new HashMap<String, Integer>(m); 
            int cnt = 0; 
            
            for (int j = 0; j < L.length; j++) {
                String str = S.substring(i + j * len2, i + (j + 1) * len2);
                
                if (!temp.containsKey(str)) {
                    break; 
                }
                
                if (temp.containsKey(str) && temp.get(str) > 0) {
                    temp.put(str, temp.get(str) - 1); 
                    cnt++; 
                }
            }
            
            if (cnt == L.length) {
                result.add(i); 
            }
        }
        
        return result; 
    }
}
