/**
 * Find the length of the longest substring without repreating characters. 
 * Use the sliding window approach. First find the first window that does not contain 
 * any repeat characters. Each time when moving left index to the right by 1, push right 
 * index as far right as possible. Update max length accordingly. Use a set to keep track 
 * of the character in a window. Note that the current window may be cleared before right
 * index can move forward (the case where the char after right index is the same char).
 */ 
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        int left = 0; 
        int right = 0; 
        set.add(s.charAt(0)); 

        // Find first window 
        while (right < len - 1) {
            char c = s.charAt(right + 1);
            
            if (!set.contains(c)) {
                set.add(c); 
                right++; 
            }
            else {
                break; 
            }
        }
        
        if (right == len - 1) {
            return set.size(); 
        }
        
        int max = set.size(); 
        
        while (left <= right) {
            char c = s.charAt(left);
            left++; 
            set.remove(c);
            
            while (right < len - 1) {
                char next = s.charAt(right + 1); 
                
                if (!set.contains(next)) {
                    set.add(next);
                    max = Math.max(max, set.size());
                    right++; 
                } else {
                    break; 
                }
            }
        }
        
        return max; 
    }
}
