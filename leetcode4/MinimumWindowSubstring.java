public class Solution {
    public String minWindow(String S, String T) {
        int sLen = S.length(); 
        int tLen = T.length(); 
        
        if (sLen == 0 || tLen == 0) {
            return ""; 
        }
        
        int minLen = Integer.MAX_VALUE; 
        String result = ""; 
        int count = 0; 
        
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>(); 
        Map<Character, Integer> needToFind = new HashMap<Character, Integer>(); 
        
        for (int i = 0; i < tLen; i++) {
            Character key = T.charAt(i);
            
            if (!needToFind.containsKey(key)) {
                needToFind.put(key, 1); 
            } else {
                needToFind.put(key, needToFind.get(key) + 1); 
            }
        }
        
        int left = 0; 
        int right = 0; 
        
        // Find first window
        while (right < sLen) {
            Character c = S.charAt(right); 
            
            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 1); 
            } else {
                hasFound.put(c, hasFound.get(c) + 1); 
            }
            
            if (needToFind.containsKey(c) && needToFind.get(c) >= hasFound.get(c)) {
                count++; 
                
                if (count == tLen) {  // Find first window
                    break; 
                }
            }
            
            right++; 
        }
        
        while (right < sLen) {
            while(left < right) {
                Character leftChar = S.charAt(left);
                
                if (!needToFind.containsKey(leftChar) || hasFound.get(leftChar) > needToFind.get(leftChar)) {
                    hasFound.put(leftChar, hasFound.get(leftChar) - 1); 
                    left++; 
                } else {
                    break; 
                }
            }
            
            if (right - left + 1 < minLen) {
                minLen = right - left + 1; 
                result = S.substring(left, right + 1); 
            }
            
            right++; 
            
            if (right >= sLen) {
                break; 
            }
            
            if (!hasFound.containsKey(S.charAt(right))) {
                hasFound.put(S.charAt(right), 1); 
            } else {
                hasFound.put(S.charAt(right), hasFound.get(S.charAt(right)) + 1); 
            }
        }
        
        return result; 
    }
}
