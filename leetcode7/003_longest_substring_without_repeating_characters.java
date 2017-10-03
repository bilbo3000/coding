/*
Find the longest substring of the given string without repeating characters. 

The idea was to use a hash table to keep track of the *most recent* index of each character. 
And use an array to keep track of the length of longest satisfying array ending at current character. 

Hash table -> for each character, we only care about the most recent occurrence of that character. 
Because further ahead same character cannot be in the window at all. 

Array -> essentially tells the window size of ending at each character. 

1) if the previous character fall outside the window, or not exist -> current character can extend its previous neighbor; 
2) if the previous character fall into the window -> current character cannot extend its previous neighbor; And the longest
substring ending at current character must start at the next index of its previous occurrence; 
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        // Create a map that keeps track of the most recent occurance of an element
        Map<Character, Integer> m = new HashMap<Character, Integer>(); 
        
        // Create an array that keeps track of the length of the longest non-duplicate 
        // sub-array ending at current element 
        int[] array = new int[len];
        array[0] = 1; 
        int maxResult = 1; 
        m.put(s.charAt(0), 0);
        
        for (int i = 1; i < array.length; i++) {
            char ch = s.charAt(i);
            
            if (m.containsKey(ch) && m.get(ch) >= i - array[i - 1]) {
                // ch is in previous window, so the subarray ending at current char can
                // only start from the next char after the previous ch
                // *** The part after && is very important. It makes sure ch is actually in 
                // previous window ***
                array[i] = i - m.get(ch);
            } else {
                // ch is not in previous window, so append
                array[i] = array[i - 1] + 1; 
            }
            
            // Update the max result
            maxResult = Math.max(maxResult, array[i]);
            
            // Update most recent occurrence of ch 
            m.put(ch, i);
        }
        
        return maxResult; 
    }
}
