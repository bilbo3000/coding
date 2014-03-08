public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        Map<String, Integer> m = new HashMap<String, Integer>(); 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        int llen = L.length; 
        int slen = S.length(); 
        
        if (llen == 0 || slen == 0) {
            return result; 
        }
        
        for (int i = 0; i < L.length; i++) {
            if (!m.containsKey(L[i])) {
                m.put(L[i], 0); 
            }
            
            m.put(L[i], m.get(L[i]) + 1); 
        }
        
        int wordlen = L[0].length(); 
        
        for (int i = 0; i <= slen - wordlen * llen; i++) {
            Map<String, Integer> temp = new HashMap<String, Integer>(m); 
            int cnt = 0;  // Number of words found 
            
            while (cnt < llen) {
                String key = S.substring(i + cnt * wordlen, i + cnt * wordlen + wordlen);
                
                if (temp.containsKey(key) && temp.get(key) > 0) {
                    temp.put(key, temp.get(key) - 1); 
                    cnt++; 
                }
                else {
                    break; 
                }
            }
            
            if (cnt == llen) {
                result.add(i); 
            }
        }
        
        return result; 
    }
}
