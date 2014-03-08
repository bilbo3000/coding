public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>(); 
        ArrayList<String> result = new ArrayList<String>(); 
        Set<String> keys = new HashSet<String>(); 
        
        for (String item : strs) {
            char[] arr = item.toCharArray(); 
            Arrays.sort(arr); 
            String key = new String(arr);
            
            if (!m.containsKey(key)) {
                ArrayList<String> temp = new ArrayList<String>(); 
                temp.add(item); 
                m.put(key, temp); 
            }
            else {
                m.get(key).add(item); 
                keys.add(key); 
            }
        }
        
        for (String key : keys) {
            result.addAll(m.get(key)); 
        }
        
        return result; 
    }
}
