public class Solution {
    public String minWindow(String S, String T) {
        int cnt = 0;   // Used for finding the first window
        int len = 0;   // Length of current window 
        int min = 0; 
        boolean found = false; 
        String result = ""; 
        Map<Character, Integer> needToFind = new HashMap<Character, Integer>(); 
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>(); 
        
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i); 
            
            if (!needToFind.containsKey(c)) {
                needToFind.put(c, 1); 
            }
            else {
                needToFind.put(c, needToFind.get(c) + 1); 
            }
        }

        // Find first window 
        int i = 0; 
        
        while (i < S.length()) {
            char c = S.charAt(i); 
            
            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 1); 
            }
            else {
                hasFound.put(c, hasFound.get(c) + 1); 
            }
            
            len++; 
  
            if (needToFind.containsKey(c) && (needToFind.get(c) >= hasFound.get(c))) {
                cnt++;  
            }
            
            if (cnt == T.length()) {
                if (!found) {
                    found = true; 
                    min = len; 
                    result = S.substring(0, i + 1);
                }
                
                // Try to move left 
                int j = i - len + 1; 
                char temp = S.charAt(j); 
                
                while (!needToFind.containsKey(temp) || needToFind.get(temp) < hasFound.get(temp)) {
                	hasFound.put(temp, hasFound.get(temp) - 1); 
                    len--; 
                    
                    if (len < min) {
                        min = len; 
                        result = S.substring(j + 1, i + 1); 
                    }
                    
                    j++; 
                    temp = S.charAt(j); 
                }
            }
            
            i++; 
        } 
        
        return result; 
    }
}
