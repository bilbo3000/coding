public class Solution {
    private Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
    
    public int singleNumber(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (!m.containsKey(A[i])) {
                m.put(A[i], 1); 
            }
            else {
                m.put(A[i], m.get(A[i]) + 1); 
            }
        }
        
        Iterator it = m.entrySet().iterator(); 
        int result = 0; 
        
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next(); 
            if (((Integer) pairs.getValue()) != 3) {
                result = (Integer)pairs.getKey(); 
                break; 
            } 
        }
        
        return result; 
    }
}
