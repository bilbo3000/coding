/**
 * Given a list of numbers and their frequency of occurances, return 
 * a random number with probably proportional to its weight. 
 * 
 * The idea was to create an prefix array with size n. It stores 
 * the sum of frequencies of preceding items. Then choose a random 
 * number r in [1..SUM], where SUM is the sum of all the frequencies.
 * The from the weighted array, select the ceil() of r at index. 
 * The item at index from the number array would be the result. 
 * 
 * The core idea is that the random number will fall into each index
 * of the prefix array with probably proportional to weight, because 
 * of the use of ceil() concept. 
 * 
 * Time: O(n)
 * Space: O(n)
 */ 
public class Solution {
    public int weightedRandomNumber(int[] n, int[] w) {
    	if (n == null || n.length == 0) {
    		throw new IllegalArgumentException();
    	}
    	
    	int length = n.length;
    	Random rand = new Random(); 
    	
    	// An array where each element is the sum of weights all its preceding elements
    	int[] prefix = new int[length];
    	prefix[0] = w[0]; 
    	
    	for (int i = 1; i < length; i++) {
    		prefix[i] = prefix[i - 1] + w[i]; 
    	}
    	
    	// r is a random number in [1..w[i]]
    	// note that nextInt(x) is exclusive
    	int r = rand.nextInt(prefix[length - 1]) + 1;
    	
    	// Find the index in prefix that is the ceil() of random number r
    	int index = 0; 
    	
    	while (index < length) {
    		if (prefix[index] >= r) {
    			// Found index of ceil() of random number r
    			break; 
    		}
    		
    		index++; 
    	}
    	
    	// Return the number at that index
    	return n[index];
    }
}
