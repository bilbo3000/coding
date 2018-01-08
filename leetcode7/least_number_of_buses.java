import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a list of bus routes along with stops, find the least number of bus rides 
 * between any two bus stops. 
 * 
 * The idea is to build a graph with all intersect bus routes. Then starts with the 
 * but routes contains starting bus stop, do BFS, until it reaches the bus route 
 * contains the end bus stop. 
 * 
 * Thus, need a map from bus stops to routes serving them. And need another map to 
 * store the graph, i.e. intersection of bus routes. 
 */
public class Solution {
    public List<Integer> busRoute(List<String[]> buslines, String start, String end) {    	
    	// A map that maps each bus stop to its bus route
    	Map<String, Set<Integer>> m = new HashMap<>();
    	int len = buslines.size(); 
    	int i = 0; 
    	
    	while (i < len) {
    		String[] stops = buslines.get(i); 
    		
    		for (String stop : stops) {
    			if (!m.containsKey(stop)) {
    				m.put(stop, new HashSet<Integer>());
    			}
    			
    			m.get(stop).add(i);
    		}
    		
    		i++; 
    	}
    	
    	// Build a graph of intersect routes
    	Map<Integer, Set<Integer>> m2 = new HashMap<>(); 
    	
    	for (String stop : m.keySet()) {
    		Set<Integer> routes = m.get(stop);
    		
    		for (int a : routes) {
    			for (int b : routes) {
    				if (a != b) {
						if (!m2.containsKey(a)) {
							m2.put(a, new HashSet<Integer>());
						}
						
						m2.get(a).add(b);
    				}
    			}
    		}
    	}
    	
    	List<Integer> res = new ArrayList<>(); 
    	
    	// BFS to find the least number of bus routes
    	for (int route : m.get(start)) {
    		// A map of each route to its parent 
    		Map<Integer, Integer> parent = new HashMap<>(); 
    		
    		// BFS
    		Queue<Integer> q = new LinkedList<>();
    		q.add(route);
    		Set<Integer> visited = new HashSet<>();
    		
    		while (q.size() != 0) {
    			int curr = q.poll(); 
    			visited.add(curr);
    			
    			if (m.get(end).contains(curr)) {
    				// Find end bus route can reach the end
    				// Backtrack
    				int temp = curr; 
    				List<Integer> l = new ArrayList<>();
    				l.add(temp);
    				
    				while (parent.containsKey(temp)) {
    					temp = parent.get(temp);
    					l.add(0, temp); 
    				}
    				
    				if (res.size() == 0 || l.size() < res.size()) {
    					res = new ArrayList<Integer>(l); 
    				}
    				
    				break;
    			} else {
    				// Put all routes intersect with current route in 
    				// the queue for future processing
    				for (int item : m2.get(curr)) {
    					if (!visited.contains(item)) {
    						q.add(item);
    						parent.put(item, curr);
    						visited.add(item);
    					}
    				}
    			}
    		}
    	}
    	
    	return res; 
    }
}
