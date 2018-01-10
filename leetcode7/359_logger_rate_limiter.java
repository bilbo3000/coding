import java.util.HashMap;
import java.util.Map;

/**
 * Design a log rate limiter. Print a log only if it has not printed 
 * in the last 10 seconds. 
 * 
 * Maintain a map of log to its last printed timestamp. 
 * For a new log, if not in map, set its timestamp in map and return true. 
 * If in map, and last print timestamp more than 10 sec ago, update 
 * timestamp in map and return true; 
 * If in map, but last print timestamp within past 10 sec, return false; 
 * 
 * Time: O(1), hash table constant lookup; 
 * Space: O(n), hash table
 */
public class Solution {
	// A map from log to its last print timestamp
	private Map<String, Integer> m = new HashMap<>();
	
    public boolean shouldPrintMessage(int timestamp, String word) {    
    	if (!m.containsKey(word)) {
    		m.put(word, timestamp);
    		return true; 
    	} else {
    		int previousTimestamp = m.get(word); 
    		
    		if (timestamp - previousTimestamp >= 10) {
    			m.put(word, timestamp);
    			return true;
    		} else {
    			return false; 
    		}
    	}
    }
}
