/**
 * Find the minimum substring in s that contains all the characters in t. 
 * Sliding window approach. Maintain needToFind map and hasFound map. 
 * Find the first window, Each time push left index as far right as possible 
 * while maintain the property each time when moving right index to right 
 * one position at a time. 
 */ 
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needToFind = new HashMap<>(); 
        Map<Character, Integer> hasFound = new HashMap<>(); 
        int count = 0;  // How many characters we have found
        char[] sarr = s.toCharArray(); 
        char[] tarr = t.toCharArray();
        
        // Build the needToFind table
        for (int i = 0; i < tarr.length; i++) {
            if (!needToFind.containsKey(tarr[i])) {
                needToFind.put(tarr[i], 1);
            } else {
                needToFind.put(tarr[i], needToFind.get(tarr[i]) + 1);
            }
        }
        
        Map<Character, Integer> needToFindCopy = new HashMap<>(needToFind);
        
        int len = s.length(); 
        
        // Try to find the first window
        int i = 0; 
        int j = 0; 
        
        while (j < len) {
            char c = sarr[j]; 
            
            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 1); 
            } else {
                hasFound.put(c, hasFound.get(c) + 1);
            }
            
            if (needToFind.containsKey(c) && needToFind.get(c) > 0) {
                count++; 
                needToFind.put(c, needToFind.get(c) - 1);
                if (count == t.length()) {
                    break; 
                }
            }
            
            j++; 
        }
        
        if (count != t.length()) {
            return ""; 
        }
        
        int l = i; 
        int r = j; 
        int min = j - i + 1;  
        
        while (j < len) {
        	while (i < j) {
                if (!needToFind.containsKey(sarr[i]) || hasFound.get(sarr[i]) > needToFindCopy.get(sarr[i])) {
                    hasFound.put(sarr[i], hasFound.get(sarr[i]) - 1);
                    i++; 
                    
                    if (j - i + 1 < min) {
                        min = j - i + 1; 
                        l = i; 
                        r = j; 
                    }
                } else {
                    break; 
                }
            }
        	
        	if (j < len - 1) {
	            char c = sarr[j + 1]; 
	            
	            if (!hasFound.containsKey(c)) {
	                hasFound.put(c, 1); 
	            } else {
	                hasFound.put(c, hasFound.get(c) + 1);
	            }
        	}
        	
            j++; 
        }
        
        return s.substring(l, r + 1); 
    }
}
