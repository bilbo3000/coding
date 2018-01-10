import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter that returns the hit counter in last 5 mins. 
 * 
 * This approach uses a queue to store each incoming hit request timestamp. 
 * For each get hits call, it deletes timestamps that are older than past 
 * 5 mins starting from the front of the queue. Note that those deleted 
 * timestamps no longer relevant. 
 * 
 * The number of items left in the queue would be be number of hits in the 
 * past 5 mins. 
 * 
 * Time: hit: O(1), append to the end of the queue; 
 * 	 	 get hits: O(n), worse case need to delete everything from the queue; 
 * Space: O(n), the queue, worse case store all calls. 
 */
public class Solution {
	private Queue<Integer> queue = new LinkedList<>();
	
	public void hit(int timestamp) {
		queue.add(timestamp);
	}
	
    public int getHits(int timestamp) {    
    	while (queue.peek() <= (timestamp - 300)) {
    		// Delete hits older than 5 mins cause 
    		// they are irrelavent 
    		queue.remove();
    	}
    	
    	return queue.size(); 
    }
}
