/**
 * Check whether two strings are isomorphic where replacing characters in 
 * the first string can convert to the second string. No two characters 
 * can map to the same character. No character can maped by multiple 
 * characters. 
 * Use a map to track the mapping from the first string to the second string.
 */ 
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true; 
        }
        
        if (s.length() != t.length()) {
            return false; 
        }
        
        Map<Character, Character> m = new HashMap<>(); 
        Set<Character> set = new HashSet<>(); 
        char[] arr1 = s.toCharArray(); 
        char[] arr2 = t.toCharArray(); 
        int len = arr1.length; 
        
        for (int i = 0; i < len; i++) {
            if (!m.containsKey(arr1[i])) {
                if (set.contains(arr2[i])) {
                    // Different key map to same value
                    return false; 
                } else {
                    m.put(arr1[i], arr2[i]);
                    set.add(arr2[i]);
                }
            } else {
                if (m.get(arr1[i]) != arr2[i]) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
}
