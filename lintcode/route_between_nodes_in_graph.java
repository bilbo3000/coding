/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     * Traverse the graph using BFS and use a set to keep track of the visited 
     * node. 
     * O(n) because the worse case all nodes are visited once. 
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return true; 
        }
        
        Set<DirectedGraphNode> history = new HashSet<>(); 
        Queue<DirectedGraphNode> queue = new LinkedList<>(); 
        
        if (s != null) {
            queue.add(s);
            history.add(s);
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.remove(); 
            
            for (DirectedGraphNode item : node.neighbors) {
                if (item == t) {
                    return true; 
                }
                
                if (!history.contains(item)) {
                    history.add(item);
                    queue.add(item);
                }
            }
        }
        
        return false; 
    }
}
