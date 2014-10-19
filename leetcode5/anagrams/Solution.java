public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>(); 
        List<String> result = new ArrayList<String>(); 
        
        for (String s : strs) {
            char[] arr = s.toCharArray(); 
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            
            if (!m.containsKey(key)) {
                List<String> temp = new ArrayList<String>(); 
                temp.add(s);
                m.put(key, temp); 
            } else {
                m.get(key).add(s); 
            }
        }
        
        for (String key : m.keySet()) {
            List<String> temp = m.get(key); 
            if (temp.size() > 1) {
                result.addAll(temp); 
            }
        }
        
        return result; 
    }
}
