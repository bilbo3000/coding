/**
 * Design a hit counter and able to return the number of hits within 
 * past 5 mins. 
 * 
 * This approach uses two fixed size arrays with size 300, times and counts, 
 * to store timestamp and associated hits respectively. 
 * 
 * For each timestamp, modulo with 300 as the index of the times array. 
 * The core idea behind this array is that 1) we never need to store more 
 * than 300 different timestamp, cause 301 invalidates 1, 302 invalidates 2, so 
 * on so forth --> think about modulo. 
 * 
 * If after modulo, current timestamp is the same as it's previous value at 
 * that index, meaning the same timestamp, increment the counter. Otherwise, 
 * meaning previous value becomes invalid. Overwirte previous timestamp with 
 * new one and reset the hits to 1. 
 *
 * Summary: fixed size array used with modulo can invalidates items that 
 * fall out of a current fixed size window. 
 * 
 * Time: hit: O(1), update an entry in each array; 
 *  	get hit: O(n), adds up values in counts array; 
 * Space: O(1), fixed size array; 
 */
public class Solution {
	int[] times = new int[300];
	int[] counts = new int[300]; 
	
	public void hit(int timestamp) {
		int index = timestamp % 300; 
		
		if (timestamp == times[index]) {
			// Another hit at the same time, 
			// increase its counter 
			counts[index]++; 
		} else {
			// The old value at times[index] must fall out 
			// the past 5 min window thus expired. Update 
			// timestamp and reset count to 1.
			// However, the array will not always contain the 
			// value within past 5 mins. A value stays in the 
			// array until next value invalidates it. Thus in
			// getHits method, still need to verify timestamp. 
			times[index] = timestamp; 
			counts[index] = 1; 
		}
	}
	
    public int getHits(int timestamp) {    
    	// Going through times and counts, anything 
    	// within last 5 mins count
    	int cnt = 0; 
    	
    	for (int i = 0; i < 300; i++) {
    		if (times[i] > (timestamp - 300)) {
    			// Within last 5 mins, include its hits
    			cnt += counts[i]; 
    		}
    	}
    	
    	return cnt; 
    }
}
