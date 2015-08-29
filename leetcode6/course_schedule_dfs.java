/**
 * Determine if all courses can be taken in a topoloical graph. 
 * This problem is actually determine whether the direct graph has a circle. 
 * This is the DFS solution. The idea was to find all courses that do not have prerequisite to 
 * start DFS traversal via maintaining a visit array to mark the status of each node. Whenever DFS 
 * found a cycle, return false. Otherwise continue. After all DFS returns, make sure double check 
 * whether the total number of nodes we visited is equal to the total number of nodes. It is because 
 * part of the graph could be a circle and never been visited by DFS. 
 */ 
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Find courses that do not have prerequisites
        int[] pre = new int[numCourses];
        int height = prerequisites.length; 
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < height; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1]; 
            pre[a]++; 
            
            if (!m.containsKey(b)) {
                m.put(b, new ArrayList<Integer>());
            }
            
            m.get(b).add(a);
        }
        
        int[] visit = new int[numCourses]; 
        
        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0 && visit[i] == 0) {
                boolean result = dfs(i, visit, m);
                
                if (!result) {
                    return false; 
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] != 1) {
                return false; 
            }
        }
        
        return true;
    }
    
    private boolean dfs(int course, int[] visit, Map<Integer, List<Integer>> m) {
        if (visit[course] == -1) {
            // Found a cycle, return false
            return false; 
        }
        
        if (visit[course] == 1) {
            // Do not need to go down from the same point that has been succeeded
            return true; 
        }
        
        // Start visiting down from current node 
        visit[course] = -1; 
        if (m.containsKey(course)) {
            for (int item : m.get(course)) {
                boolean result = dfs(item, visit, m);
                if (!result) {
                    return false; 
                }
            }
        }
        visit[course] = 1; 
        
        return true; 
    }
}
