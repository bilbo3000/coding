/**
 * Given a string and a dictionary, add bold tags to the 
 * string around words that are in the dictionary. 
 * 
 * The core idea is to merge interval. Loop through the dictionary 
 * and check each word against all the substrings in the string 
 * with the same length. (Faster than check all the substrings 
 * against the dictionary). Store each interval of words beginning 
 * and end index. 
 * 
 * Sort intervals based on begin index break even on end index. 
 * (Think about sorting intervals whenever working with intervals). 
 * 
 * Loop through the list and merge intervals and add bold tags 
 * surround each section. 
 * 
 * Time: O(l * s * x), l: size of dictionary; s: length of the array; 
 * x: average length of word in dictionary; 
 * Space: O(s + l * s), res size grow to O(s); list size grow to O(l * s); 
 */
public class Solution {
    public String addBoldTag(String s, String[] dict) {
    	// A list store intervals 
    	List<int[]> list = new ArrayList<>();
    	
    	// Check each word in dict against string s
    	for (String w : dict) {
    		int len = w.length(); 
    		
    		for (int i = 0; i <= s.length() - len; i++) {
    			String sub = s.substring(i, i + len);
    			
    			if (sub.equals(w)) {
    				int[] interval = new int[2];
    				interval[0] = i; 
    				interval[1] = i + len - 1;
    				list.add(interval);
    			}
    		}
    	}
    	
    	// None in dictionary, return
    	if (list.size() == 0) {
    		return s;
    	}
    	
    	// Sort intervals
    	// Tip: sort intervals on starting point break even on ending point
    	Collections.sort(list, new Comparator<int[]>() {
    		@Override 
    		public int compare(int[] i1, int[] i2) {
    			if (i1[0] != i2[0]) {
    				return i1[0] - i2[0]; 
    			} else {
    				return i1[1] - i2[1]; 
    			}
    		}
    	});
    	    	
    	// Construct result 
    	StringBuilder sb = new StringBuilder(); 
    	
    	// First put beginning to the first start index
    	sb.append(s.substring(0, list.get(0)[0]));
    	
    	int[] prevInterval = null;
    	
    	// Going through all the intervals 
    	for (int[] interval : list) {
    		if (prevInterval == null) {
    			// First interval
    			sb.append("<b>");
    			sb.append(s.substring(interval[0], interval[1] + 1));
    		} else {
    			// Check against previous interval
    			// And see if there's overlap 
    			if (interval[0] <= prevInterval[1] + 1) {
    				// Overlap
    				if (interval[1] > prevInterval[1]) {
    					// not fully contain
    					sb.append(s.substring(prevInterval[1] + 1, interval[1] + 1));
    				} 
    			} else {
    				// Does not overlap 
    				// Close previous section 
    				sb.append("</b>");
    				
    				// Append whether every in between
    				sb.append(s.substring(prevInterval[1] + 1, interval[0])); 
    				
    				// Start out new section
    				sb.append("<b>");
    				sb.append(s.substring(interval[0], interval[1] + 1));
    			}
    		}
    		
    		prevInterval = interval; 
    	}
    	
    	// Put remaining
    	sb.append("</b>");
    	sb.append(s.substring(prevInterval[1] + 1));
    	
    	return sb.toString();
    }
}
