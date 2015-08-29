/**
 * Determine if all courses can be taken in a topoloical graph. 
 * This problem is actually determine whether the direct graph has a circle. 
 * This is the BFS solution. The idea was to find all courses that do not have prerequisite to 
 * start BFS traversal. Also count the number of prerequisites of each course. When a fully taken 
 * course make a course prerequisites count goes down to zero, add that course to fully taken 
 * course queue. Also maintain the count of fully taken courses. In the end, if the number of 
 * fully taken course is the same as the course count, then return true. Otherwise, return false. 
 */ 
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses];
        int len = prerequisites.length; 
        
        for (int i = 0; i < len; i++) {
            int course = prerequisites[i][0];
            pre[course]++; 
        }
        
        // Courses with no untaken prerequisites
        Queue<Integer> queue = new LinkedList<>(); 
        
        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0) {
                queue.add(i);
            }
        }
        
        int takenCount = queue.size(); 
        
        while (queue.size() > 0) {
            int top = queue.remove(); 
            
            for (int i = 0; i < len; i++) {
                int a = prerequisites[i][0]; 
                int b = prerequisites[i][1];
                
                if (top == b) {
                    pre[a]--; 
                    
                    if (pre[a] == 0) {
                        queue.add(a);
                        takenCount++; 
                    }
                }
            }
        }
        
        if (takenCount == numCourses) {
            return true; 
        }
        
        return false; 
    }
}
