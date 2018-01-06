import java.util.Arrays;

/**
 * Given a string and a dictionary. Add bold tags surround words 
 * that are in dictionary. 
 * 
 * The idea is to use a boolean array to mark section of string that 
 * contains characters that make up dictionary words. And surround each 
 * true block with bold tags should be the results. 
 * 
 * Note, Arrays.fill(arr, l, r + 1, false); can be used to fill array.  
 * 
 * Time: O(l * s * x), time used to fill the boolean array; l: size of dictionary; s: size of string; 
 * x: average length of words in dictionary; 
 * Space: O(s), both res and boolean array size grow up to O(s); 
 */
public class Solution {
    public String addBoldTag(String s, String[] dict) {
    	int size = s.length(); 
    	boolean[] arr = new boolean[size];
    	
    	// Check each word in dict against string s
    	for (String w : dict) {
    		int len = w.length(); 
    		
    		for (int i = 0; i <= s.length() - len; i++) {
    			String sub = s.substring(i, i + len);
    			
    			if (sub.equals(w)) {
    				int l = i; 
    				int r = i + len - 1;
    				Arrays.fill(arr, l, r + 1, true);
    			}
    		}
    	}
    	    	
    	// Construct result 
    	StringBuilder sb = new StringBuilder(); 
    	boolean prev = false; 
    	
    	for (int i = 0; i < size; i++) {
    		if (arr[i]) {
    			if (!prev) {
    				// Start a true section 
    				sb.append("<b>");
    				sb.append(s.charAt(i));
    			} else {
    				// Continue a true section 
    				sb.append(s.charAt(i));
    			}
    		} else {
    			if (prev) {
    				// End a true section 
    				sb.append("</b>");
    				sb.append(s.charAt(i));
    			} else {
    				// Continue a false section 
    				sb.append(s.charAt(i));
    			}
    		}
    		
    		prev = arr[i]; 
    	}
    	
    	if (prev) {
    		// End last true section 
    		sb.append("</b>");
    	}
    	
    	return sb.toString();
    }
}
