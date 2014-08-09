/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        Set<UndirectedGraphNode> history = new HashSet<UndirectedGraphNode>(); 
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        
        if (root == null) {
            return null; 
        }
        
        q.add(root);
        
        while (q.size() != 0) {
            UndirectedGraphNode curr = q.remove(); 
            
            if (history.contains(curr)) {
                continue; 
            }
            
            if (!m.containsKey(curr)) {
                UndirectedGraphNode node = new UndirectedGraphNode(curr.label);
                m.put(curr, node); 
            }
            
            for (UndirectedGraphNode item : curr.neighbors) {
                if (!m.containsKey(item)) {
                    UndirectedGraphNode node = new UndirectedGraphNode(item.label);
                    m.put(item, node); 
                }
                
                m.get(curr).neighbors.add(m.get(item)); 
            }
            
            history.add(curr);
            
            for (UndirectedGraphNode item : curr.neighbors) {
                q.add(item); 
            }
        }
        
        return m.get(root); 
    }
}
