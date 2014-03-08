public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int len = s.length(); 
        Set<Character> set = new HashSet<Character>(); 
        int left = 0; 
        int right = 0; 
        
        while (right < len ) {
            while (right < len && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
                right++; 
            }
            
            set.remove(s.charAt(left)); 
            left++; 
        }
        
        return max; 
    }
}
