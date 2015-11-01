/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 * 
 * BFS solution. 
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>(); 
        Map<DirectedGraphNode, Integer> m = new HashMap<>(); 
        
        for (DirectedGraphNode item : graph) {
            for (DirectedGraphNode child : item.neighbors) {
                if (m.containsKey(child)) {
                    m.put(child, m.get(child) + 1);
                } else {
                    m.put(child, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>(); 
        
        for (DirectedGraphNode item : graph) {
            if (!m.containsKey(item)) {
                queue.add(item);
                result.add(item);
            }
        }
        
        while (queue.size() != 0) {
            DirectedGraphNode node = queue.remove(); 
            
            for (DirectedGraphNode child : node.neighbors) {
                if (m.get(child) > 0) {
                    m.put(child, m.get(child) - 1);
                    
                    if (m.get(child) == 0) {
                        queue.add(child);
                        result.add(child);
                    }
                }
            }
        }
        
        return result; 
    }
}
