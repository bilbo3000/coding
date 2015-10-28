public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     * Sliding window approach. Use a set represent the window. Each time remove 
     * the left most element, try to push the right bound as far right as possible. 
     * Update the max window size each iteration. 
     * 
     * O(n) time. 
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0; 
        Set<Character> window = new HashSet<>(); 
        int i = 0; 
        int len = s.length(); 
        
        while (i < len && !window.contains(s.charAt(i))) {
            window.add(s.charAt(i));
            i++; 
        }
        
        if (i == len) {
            return window.size(); 
        }
        
        res = window.size(); 
        
        while (i < len) {
            int size = window.size(); 
            window.remove(s.charAt(i - size)); 
            
            // Push i as far as possible 
            while (i < len && !window.contains(s.charAt(i))) {
                window.add(s.charAt(i));
                i++; 
                res = Math.max(res, window.size());
            }
        }
        
        return res; 
    }
}
