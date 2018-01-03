/**
 * Given a list of course prerequites pairs, [0, 1] means course 0 is a prerequite of 
 * course 1. Determine if can finish all the courses. aka, no cycles in the graph. 
 * 
 * Topological sort using DFS. Loop through each unvisited node and run dfs through it. 
 * For each dfs, keep track of all the nodes visited so far to check for cycles. 
 * For each node, recurse on all the unvisited neighbors. Use an array to keep track of 
 * all the visited/unvisited nodes. 
 * 
 * Time: O(n), linear,each edge is visited once. 
 * Space: O(n), a map store each node an all its neighbors. 
 */ 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Put all theMap<K, V>ges into a map
    	Map<Integer, List<Integer>> map = new HashMap<>();  
    	
    	for (int i = 0; i < prerequisites.length; i++) {
    		int key = prerequisites[i][0]; 
    		int value = prerequisites[i][1]; 
    		
    		if (!map.containsKey(key)) {
    			map.put(key, new ArrayList<Integer>());
    		}
    		
    		map.get(key).add(value); 
    	}
    	
    	// An array record whether each element is visited 
    	boolean[] visited = new boolean[numCourses]; 
    	
    	// Run DFS through each node
    	for (int i = 0; i < numCourses; i++) {
    		if (!visited[i]) {
    			boolean res = dfs(i, map, visited, new HashSet<Integer>());
    			
    			if (!res) {
    				return false; 
    			}
    		}
    	}
    	
    	return true; 
    }
    
    private boolean dfs(int num, Map<Integer, List<Integer>> map, boolean[] visited, Set<Integer> path) {
    	if (path.contains(num)) {
    		// Found a circle
    		return false; 
    	}
    	
    	// Add current node to path
    	path.add(num);
    	
    	if (!map.containsKey(num)) {
    		// Found a sink
    		visited[num] = true; 
    		return true;
    	}
    	
    	for (int item : map.get(num)) {
    		// Recurse on each edge
    		if (!visited[item]) {
	    		boolean res = dfs(item, map, visited, path);
	    		
	    		if (!res) {
	    			return false; 
	    		}
    		}
    	}
    	
    	visited[num] = true;
    	return true; 
    }
}
