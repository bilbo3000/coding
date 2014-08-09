public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>(); 
        Map<String, List<String>> m = new HashMap<String, List<String>>(); 
        
        for (String s : strs) {
            char[] charArr = s.toCharArray(); 
            Arrays.sort(charArr); 
            String key = new String(charArr);
            
            if (!m.containsKey(key)) {
                List<String> val = new ArrayList<String>(); 
                val.add(s);
                m.put(key, val); 
            } else {
                m.get(key).add(s); ; 
            }
        }
        
        Set<String> keySet = m.keySet(); 
        for (String key : keySet) {
            if (m.get(key).size() > 1) {
                result.addAll(m.get(key)); 
            }
        }
        
        return result; 
    }
}
