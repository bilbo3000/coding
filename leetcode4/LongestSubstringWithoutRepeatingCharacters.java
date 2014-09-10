public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        int currLen = 0; 
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>(); 
        int left = 0; 
        int right = 1; 
        max = 1; 
        hasFound.put(s.charAt(0), 1); 
        
        while (right < len) {
            while (right < len) {
                Character key = s.charAt(right);
                if (!hasFound.containsKey(key) || hasFound.get(key) == 0) {
                    hasFound.put(key, 1); 
                    right++; 
                } else {
                    break; 
                }
            }
            
            max = Math.max(max, right - left); 
            hasFound.put(s.charAt(left), hasFound.get(s.charAt(left)) - 1);
            left++; 
        }
        
        return max; 
    }
}
