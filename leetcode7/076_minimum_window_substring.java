/*
Find the minimum window of substring. 

Maintain two maps of characters count: hasFound and needToFind. 
First try to find the first window [0..j] that satisfy the constraints (return "" if not found). 
Then for each iteration, try to move left as right as possible while hold the constraints. 
(Compare hasFound value against needToFind value and decide whether can move). 
Update min, left, and right accordingly. 
Move right one position at a time and repeat above process. 

Time: O(n), each element is visited once; 
Space: O(n), use map to track hasFound elements; 
*/ 
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return ""; 
        }
        
        int len = s.length(); 
        
        // Build a map of count of characters need to find
        Map<Character, Integer> needToFind = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            
            if (!needToFind.containsKey(c)) {
                needToFind.put(c, 1);
            } else {
                needToFind.put(c, needToFind.get(c) + 1);
            }
        }
        
        // A back up of needToFind
        Map<Character, Integer> needToFindCopy = new HashMap<>(needToFind); 
        
        // A map of count of characters has found
        Map<Character, Integer> hasFound = new HashMap<>();
        
        // Find the first window
        int i = 0; 
        int j = 0; 
        int count = 0; 
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        
        while (j < len) {
            if (needToFind.containsKey(sarr[j]) && needToFind.get(sarr[j]) > 0) {
                count++; 
                needToFind.put(sarr[j], needToFind.get(sarr[j]) - 1);
            }
            
            if (!hasFound.containsKey(sarr[j])) {
                hasFound.put(sarr[j], 1);
            } else {
                hasFound.put(sarr[j], hasFound.get(sarr[j]) + 1);
            }
            
            if (count == t.length()) {
                break; 
            }
            
            j++; 
        }
        
        if (count != t.length()) {
            // Cannot find any window, return 
            return ""; 
        }
        
        int min = j - i + 1; 
        int l = i; 
        int r = j; 
        
        // Found the first window [0, j]
        // Move j one at a time, meanwhile, try to move i as left as possible 
        // while maintaining the invariants
        while (j < len) {
            while (!needToFindCopy.containsKey(sarr[i]) || hasFound.get(sarr[i]) > needToFindCopy.get(sarr[i])) {
                hasFound.put(sarr[i], hasFound.get(sarr[i]) - 1);
                i++; 
            }
            
            // Try to update min
            if (j - i + 1 < min) {
                min = j - i + 1; 
                l = i; 
                r = j; 
            }
            
            // Move j to right one position 
            if (j + 1 < len) {
                if (!hasFound.containsKey(sarr[j + 1])) {
                    hasFound.put(sarr[j + 1], 1);
                } else {
                    hasFound.put(sarr[j + 1], hasFound.get(sarr[j + 1]) + 1);
                }
            }
            
            j++; 
        }
        
        return s.substring(l, r + 1);
    }
}
