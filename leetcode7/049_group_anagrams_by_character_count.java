/*
Group anagrams together. 

Use character count as the key of each string.

Two strings are anagrams if their character count are the same. 

Use String #n1#n2#...#n to represent a character count. 

Use a hash table to map key to a list of values with that key. 

Time: O(nxk)
Space: O(n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>(); 
        
        for (String item : strs) {
            int[] count = new int[26];
            Arrays.fill(count, 0);
            
            for (int i = 0; i < item.length(); i++) {
                count[(int)(item.charAt(i) - 'a')]++;
            }
            
            StringBuilder sb = new StringBuilder(); 
            
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append('a' + count[i]);
            }
            
            String key = sb.toString(); 
            
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
