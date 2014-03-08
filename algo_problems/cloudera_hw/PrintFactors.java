import java.util.*;

/**
 * Print all possible multiplications for given number. 
 * @author Dongpu
 *
 */
public class PrintFactors {
	// A set to keep track of the hisotry to avoid duplicates 
	private Set<ArrayList<Integer>> history = new HashSet<ArrayList<Integer>>(); 
	
	// List of results
	private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
	
	/*
	 * Generates lists of factorization result numbers. 
	 */
    public ArrayList<ArrayList<Integer>> multiply(int n) {
    	// 1 multiplies the number itself
    	ArrayList<Integer> temp = new ArrayList<Integer>(); 
    	temp.add(n);
    	temp.add(1);
    	result.add(temp);
    	
    	// Recursively generate factorizations
    	helper(n, new ArrayList<Integer>()); 
    	
    	return result; 
    }
    
    /*
     * Recursively generate non-duplicated factorizations
     */
    private void helper(int n, ArrayList<Integer> curr) {    	
    	if (n == 1) {  // Base case when n is 1
    		return; 
    	}
    	
    	if (n == 2 || n == 3) {  // Base case when n is 2 or 3
    		curr.add(n); 
    		ArrayList<Integer> temp = new ArrayList<Integer>(curr); 
    		Collections.sort(temp); 
    		
    		if (!history.contains(temp)) {  // Collect the result only if it not been seen
    			result.add(curr); 
    			history.add(temp); 
    		}
    		
    		return; 
    	} 
    	
    	// Try all possible factors and recursively process the remaining number. 
    	for (int i = n - 1; i > 1; i--) {
    		if (n % i == 0) {  // Find a possible factorization
    			// Recursive case
    			ArrayList<Integer> next1 = new ArrayList<Integer>(curr);
    			ArrayList<Integer> next2 = new ArrayList<Integer>(curr); 
    			next1.add(i); 
    			helper(n / i, next1);
    			
    			// Non-recursive case
    			next2.add(i);
    			next2.add(n / i); 
    			ArrayList<Integer> temp = new ArrayList<Integer>(next2); 
    			Collections.sort(temp); 
    			
    			if (!history.contains(temp)) {  // Collect result only if it not been seen
    				result.add(next2);
    				history.add(temp); 
    			}
    		}
    	}
    }
    
    /*
     * Main function that collects the results. 
     */ 
    public static void main(String [] args) {
    	// Validate parameter. 
    	if (args.length != 1) {
    		System.err.println("Invalid parameter."); 
    		return; 
    	} 
    	
    	try {
			int n = Integer.parseInt(args[0]); 
		    PrintFactors sln = new PrintFactors();
		    ArrayList<ArrayList<Integer>> result = sln.multiply(n); 
		    
		    // Print out the result
	        for (ArrayList<Integer> factor : result) {
				StringBuilder builder = new StringBuilder(); 
				builder.append(factor.get(0)); 
				
				for (int i = 1; i < factor.size(); i++) {
					builder.append("*").append(factor.get(i)); 
				}
				
				System.out.println(builder.toString()); 
			}
		    
        } catch (Exception e) {
        	e.printStackTrace(); 
        }
    }
}
