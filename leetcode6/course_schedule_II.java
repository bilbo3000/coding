/**
 * Return a list of courses in topological order. 
 * The idea was to traverse through the graph starting from the courses that do not 
 * have prerequisites in a BFS fashion via queue approach. And collect fully visited 
 * nodes. Do not forget to check whether the number of nodes we have visited is the 
 * same as the total number of nodes, becuase there could be part of the graph that 
 * has circle and has never been visited. 
 */ 
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int height = prerequisites.length; 
        int[] preCount = new int[numCourses]; 
        int[] result = new int[numCourses]; 
        int index = 0; 
        
        for (int i = 0; i < height; i++) {
            int a = prerequisites[i][0]; 
            int b = prerequisites[i][1]; 
            preCount[a]++; 
        }
        
        Queue<Integer> queue = new LinkedList<>(); 
        
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                queue.add(i);
            }
        }
        
        while (queue.size() != 0) {
            int top = queue.remove(); 
            result[index] = top; 
            index++; 
            
            for (int i = 0; i < height; i++) {
                int a = prerequisites[i][0]; 
                int b = prerequisites[i][1]; 
                
                if (b == top) {
                    preCount[a]--; 
                    
                    if (preCount[a] == 0) {
                        // This node a does not have any more prerequisites, save to the queue
                        queue.add(a);
                    }
                }
            }
        }
        
        if (index != numCourses) {
            return new int[0]; 
        }
        
        return result; 
    }
}
