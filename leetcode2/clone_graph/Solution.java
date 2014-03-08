/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
    private Set<UndirectedGraphNode> history = new HashSet<UndirectedGraphNode>(); 
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null; 
        
        cloneDFS(node); 
        
        return m.get(node); 
    }
    
    public void cloneDFS(UndirectedGraphNode node) {
        if (history.contains(node)) return; 
        
        if (!m.containsKey(node)) {
            m.put(node, new UndirectedGraphNode(node.label)); 
        }
        
        UndirectedGraphNode newNode = m.get(node); 
        
        for (int i = 0; i < node.neighbors.size(); i++) {
            UndirectedGraphNode nb = node.neighbors.get(i); 
            
            if (!m.containsKey(nb)) {
                m.put(nb, new UndirectedGraphNode(nb.label)); 
            }
            
            newNode.neighbors.add(m.get(nb)); 
        }
        
        history.add(node); 
        
        for (int i = 0; i < node.neighbors.size(); i++) {
            cloneDFS(node.neighbors.get(i)); 
        }
    }
}
