/*
Group anagrams together. 

Sort each element to be the key. 

Use a hash table to map key to a list of values with that key. 

Time: O(n^2logn)
Space: O(n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>(); 
        
        for (String item : strs) {
            char[] arr = item.toCharArray(); 
            Arrays.sort(arr);
            String key = new String(arr);
            
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<String>());
            }
            
            m.get(key).add(item);
        }
        
        List<List<String>> result = new ArrayList<List<String>>(); 
        
        for (String key : m.keySet()) {
            result.add(m.get(key));
        }
        
        return result; 
    }
}
