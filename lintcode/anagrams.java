public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     * 
     * O(n) time. 
     */
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>(); 
        List<String> res = new ArrayList<>(); 
        
        for (String item : strs) {
            if (item.length() == 0) {
                if (!m.containsKey(item)) {
                    m.put(item, new ArrayList<String>());
                }
                
                m.get(item).add(item);
            } else {
                char[] arr = item.toCharArray(); 
                Arrays.sort(arr);
                String key = String.valueOf(arr);
                
                if (!m.containsKey(key)) {
                    m.put(key, new ArrayList<String>());
                }
                
                m.get(key).add(item);
            }
        }
        
        for (String key : m.keySet()) {
            if (m.get(key).size() > 1) {
                res.addAll(m.get(key));
            }
        }
        
        return res; 
    }
}
