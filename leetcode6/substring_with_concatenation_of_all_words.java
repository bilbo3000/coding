/**
 * Find starting index of substrings that are formed by concatenation of all 
 * words in a dictionary. 
 * The idea was to store words and its count in a map. And for each possible 
 * starting point, check whether the substring satisfy the constraint. Nothing 
 * tricky. 
 */ 
public class Solution {
    private List<Integer> result = new ArrayList<>(); 
    private int len = 0; 
    private int totalLen = 0; 
    
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> m = new HashMap<>();
        len = words[0].length(); 
        totalLen = len * words.length; 
        
        for (String word : words) {
            if (!m.containsKey(word)) {
                m.put(word, 1);
            } else {
                m.put(word, m.get(word) + 1);
            }
        }
        
        for (int i = 0; i <= s.length() - totalLen; i++) {
            helper(s, i, i, new HashMap<String, Integer>(m));
        }
        
        return result; 
    }
    
    private void helper(String s, int start, int curr, Map<String, Integer> m) {
        if (curr - start == totalLen) {
            result.add(start);
            return; 
        }
        
        String str = s.substring(curr, curr + len);
        
        if (!m.containsKey(str) || m.get(str) == 0) {
            return; 
        }
        
        m.put(str, m.get(str) - 1);
        
        helper(s, start, curr + len, m);
    }
}
