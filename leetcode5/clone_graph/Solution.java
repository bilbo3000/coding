/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        Set<UndirectedGraphNode> history = new HashSet<UndirectedGraphNode>(); 
        List<List<UndirectedGraphNode>> levels = new ArrayList<List<UndirectedGraphNode>>(); 
        levels.add(new ArrayList<UndirectedGraphNode>()); 
        levels.add(new ArrayList<UndirectedGraphNode>());
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (node == null) {
            return null; 
        }
        
        levels.get(lev0).add(node);
        
        while (levels.get(lev0).size() != 0) {
            List<UndirectedGraphNode> curr = levels.get(lev0); 
            List<UndirectedGraphNode> next = levels.get(lev1); 
            
            for (UndirectedGraphNode item : curr) {
                if (history.contains(item)) {
                    continue; 
                }
                
                if (!m.containsKey(item)) {
                    m.put(item, new UndirectedGraphNode(item.label)); 
                }
                
                for (UndirectedGraphNode neighbor : item.neighbors) {
                    if (!m.containsKey(neighbor)) {
                        m.put(neighbor, new UndirectedGraphNode(neighbor.label)); 
                    }
                    
                    m.get(item).neighbors.add(m.get(neighbor)); 
                    
                    if (!history.contains(neighbor)) {
                        next.add(neighbor); 
                    }
                }
                
                history.add(item); 
            }
            
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return m.get(node); 
    }
}
