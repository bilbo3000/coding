/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>(); 
        Set<UndirectedGraphNode> history = new HashSet<>(); 
        Queue<UndirectedGraphNode> queue = new LinkedList<>(); 
        
        if (node != null) {
            queue.add(node);
        }
        
        while (queue.size() != 0) {
            UndirectedGraphNode curr = queue.remove(); 
            
            if (history.contains(curr)) {
                continue; 
            }
            
            if (!m.containsKey(curr)) {
                UndirectedGraphNode temp = new UndirectedGraphNode(curr.label);
                m.put(curr, temp);
            }
            
            for (UndirectedGraphNode child : curr.neighbors) {
                if (!m.containsKey(child)) {
                    UndirectedGraphNode temp = new UndirectedGraphNode(child.label);
                    m.put(child, temp);
                }
                
                m.get(curr).neighbors.add(m.get(child));
                queue.add(child);
            }
            
            history.add(curr);
        }
        
        return m.get(node);
    }
}
