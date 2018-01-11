/**
 * Given two strings, check whether exact 1 edit can convert 
 * first string to the second. 
 * 
 * If their length difference is greater than 1, then there is 
 * on way to have 1 edit distance, thus return false. 
 * 
 * Have a counter to keep track of different characters. Have two 
 * pointers move along two strings respectively. 
 * 
 * If two characters are the same, advance both pointers --> no edit. 
 * If two characters are different, increment the counter, and do the following: 
 * - if two strings length are the same, then only edit can be replace current 
 * character, thus advance both pointers to continue examine. The rest of two strings
 * must be exact the same in order to be true; 
 * 
 * - if two strings length are different, then the only edit is to delete 
 * the current character from the longer string, thus advance the pointer 
 * of longer string. The rest of the two stings must be exactly the same 
 * in order to be true; 
 * 
 * After exiting the loop, if there is any character remaining, then increment the counter. 
 * 
 * In the end, the counter must be 1 in order to be true. 
 * 
 * Time: O(n), walk through two strings;
 * Space: O(1), constant number of variables;  
 */
public class Solution {
	
    boolean oneEditDistance(String word1, String word2) {  
    	int len1 = word1.length(); 
    	int len2 = word2.length(); 
    	
    	if (Math.abs(len1 - len2) > 1) {
    		return false; 
    	}
    	
    	int i = 0; 
    	int j = 0; 
    	int cnt = 0;  // Number of different char
    	
    	while (i < len1 && j < len2) {
    		if (word1.charAt(i) == word2.charAt(j)) {
    			// Two char are the same, 
    			// advance both pointers. 
    			i++; 
    			j++; 
    		} else {
    			// Two char are different
    			// increment the counter
    			cnt++; 
    			
    			if (cnt > 1) {
    				// Had more than 1 edit
    				return false; 
    			}
    			
    			if (len1 != len2) {
    				// Two strings have different lenth 
    				if (len1 > len2) {
    					// First string is longer
    					// the only possible edit is to 
    					// delete a char from the first word
    					// thus advance first pointer 
    					i++; 
    				} else {
    					// Second string is longer, 
    					// advance second pointer for the same reason 
    					j++; 
    				}
    			} else {
    				// Two strings have the same length
    				// the only possible edit is a replace
    				// advance both pointers to continue 
    				// examine. 
    				i++; 
    				j++; 
    			}
    		}
    	}
    	
    	// If there is last character in any string
    	// advance the counter 
    	if (i < len1 || j < len2) {
    		cnt++; 
    	}
    	
    	return cnt == 1; 
    }
}
