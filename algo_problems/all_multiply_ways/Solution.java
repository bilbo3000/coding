import java.util.*;
public class Solution {
	private Set<ArrayList<Integer>> history = new HashSet<ArrayList<Integer>>(); 
	private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
	
    ArrayList<ArrayList<Integer>> multiply(int n) {
    	ArrayList<Integer> temp = new ArrayList<Integer>(); 
    	temp.add(n);
    	temp.add(1);
    	result.add(temp);
    	
    	helper(n, new ArrayList<Integer>()); 
    	
    	return result; 
    }
    
    private void helper(int n, ArrayList<Integer> curr) {    	
    	if (n == 1) { 
    		return; 
    	}
    	
    	if (n == 2 || n == 3) {
    		curr.add(n); 
    		ArrayList<Integer> temp = (ArrayList<Integer>) curr.clone(); 
    		Collections.sort(temp); 
    		
    		if (!history.contains(temp)) {
    			result.add(curr); 
    			history.add(temp); 
    		}
    		
    		return; 
    	} 
    	
    	for (int i = n - 1; i > 1; i--) {
    		if (n % i == 0) {
    			ArrayList<Integer> next1 = (ArrayList<Integer>)curr.clone();
    			ArrayList<Integer> next2 = (ArrayList<Integer>)curr.clone(); 
    			next1.add(i); 
    			helper(n / i, next1);
    			
    			next2.add(i);
    			next2.add(n / i); 
    			ArrayList<Integer> temp = (ArrayList<Integer>) next2.clone(); 
    			Collections.sort(temp); 
    			
    			if (!history.contains(temp)) {
    				result.add(next2);
    				history.add(temp); 
    			}
    		}
    	}
    }
}
