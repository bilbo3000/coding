/**
 * Given a list of courses prerequisites, return one possible sequence of taking
 * the course. 
 * 
 * The idea was to loop through each unvisted node and run dfs through it. Meanwhile 
 * keep track of current order. Once finished visiting a node, add it to the order list.
 * 
 * Time: O(n), each edge is visited once. 
 * Space: O(n), each node is stored in map and result list. 
 */ 
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	boolean[] visited = new boolean[numCourses];
    	int[] results = new int[numCourses];
    	
        // Put courses into maps 
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	
    	for (int i = 0; i < prerequisites.length; i++) {
    		int u = prerequisites[i][0]; 
    		int v = prerequisites[i][1]; 
    		
    		if (!map.containsKey(u)) {
    			map.put(u, new ArrayList<Integer>());
    		}
    		
    		map.get(u).add(v);
    	}
    	
    	// Run dfs through each unvisited node 
    	List<Integer> temp = new ArrayList<>(); 
    	
    	for (int i = 0; i < numCourses; i++) {
    		if (!visited[i]) {
    			boolean res = dfs(i, map, visited, new HashSet<Integer>(), temp);
    			if (!res) {
    				return new int[]{}; 
    			}
    		}
    	}
    	
    	for (int i = 0; i < numCourses; i++) {
    		results[i] = temp.get(i);
    	} 
    	
    	return results; 
    }
    
    private boolean dfs(int num, Map<Integer, List<Integer>> map, boolean[] visited, Set<Integer> path, List<Integer> results) {
    	if (path.contains(num)) {
    		// Found a circle
    		return false; 
    	}
    	
    	path.add(num); 
    	
    	if (!map.containsKey(num)) {
    		// Found a sink
    		visited[num] = true; 
    		results.add(0, num); 
    		return true; 
    	}
    	
    	for (int item : map.get(num)) {
    		if (!visited[item]) {
    			boolean res = dfs(item, map, visited, path, results);
    			
    			if (!res) {
    				return false; 
    			}
    		}
    	}
    	
    	// Finished visiting current node 
    	visited[num] = true; 
    	results.add(0, num); 
    	return true; 
    }
    
}
