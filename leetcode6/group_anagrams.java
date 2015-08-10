/**
 * Group all anagrams together. 
 * The idea was to use a hash map to map a key (sort each item to be the key) to 
 * a list of strings. 
 */ 
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>(); 
        
        for (String s : strs) {
            char[] arr = s.toCharArray(); 
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<String>());
            }
            
            m.get(key).add(s);
        }
        
        List<List<String>> result = new ArrayList<List<String>>(); 
        
        for (String key : m.keySet()) {
            List<String> item = new ArrayList<>(m.get(key)); 
            Collections.sort(item);
            result.add(item);
        }
        
        return result; 
    }
}
