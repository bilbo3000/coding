/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * 
 * Clone a graph. 
 * The idea was to use a map to map the nodes in the given list to the nodes in the result 
 * list. Also maintain a set to keep track of the history. Traverse the graph in a BFS fashion
 * via a queue. After finish processing each node, add that node in the history set. Do not 
 * process a node if it is already in the hisotry set to avoid going around circles.
 * The lesson is we need to handle the circles in the graph. 
 */
public class Solution {
    private Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>(); 
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null; 
        }
        
        Set<UndirectedGraphNode> history = new HashSet<>(); 
        Queue<UndirectedGraphNode> q = new LinkedList<>(); 
        q.add(node);
        
        while (q.size() != 0) {
            UndirectedGraphNode curr = q.remove(); 
            
            if (history.contains(curr)) {
                continue; 
            }
            
            if (!m.containsKey(curr)) {
                m.put(curr, new UndirectedGraphNode(curr.label)); 
            }
            
            for (UndirectedGraphNode item : curr.neighbors) {
                if (!m.containsKey(item)) {
                    m.put(item, new UndirectedGraphNode(item.label));
                }
                
                m.get(curr).neighbors.add(m.get(item));
                q.add(item);
            }
            
            history.add(curr);
        }
        
        return m.get(node);
    }
}
