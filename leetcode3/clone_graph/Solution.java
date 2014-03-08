public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Set<UndirectedGraphNode> s = new HashSet<UndirectedGraphNode>();
        ArrayList<ArrayList<UndirectedGraphNode>> levels = new ArrayList<ArrayList<UndirectedGraphNode>>();
        levels.add(new ArrayList<UndirectedGraphNode>());
        levels.add(new ArrayList<UndirectedGraphNode>());
        int lev1 = 0;
        int lev2 = 1;
        levels.get(lev1).add(node);
        UndirectedGraphNode result = null;

        while (levels.get(lev1).size() != 0) {
            ArrayList<UndirectedGraphNode> curr = levels.get(lev1);
            ArrayList<UndirectedGraphNode> next = levels.get(lev2);

            for (int i = 0; i < curr.size(); i++) {
                UndirectedGraphNode currNode = curr.get(i);

                if (s.contains(currNode)) {
                    continue;
                }

                if (!m.containsKey(currNode)) {
                    m.put(currNode, new UndirectedGraphNode(currNode.label));
                }

                for (int j = 0; j < currNode.neighbors.size(); j++) {
                    UndirectedGraphNode neighbor = currNode.neighbors.get(j);
                    next.add(neighbor);

                    if (!m.containsKey(neighbor)) {
                        m.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    }

                    m.get(currNode).neighbors.add(m.get(neighbor));
                }

                if (result == null) {
                    result = m.get(currNode);
                }
                
                s.add(currNode); 
            }

            curr.clear();
            lev1 = lev1 ^ lev2;
            lev2 = lev1 ^ lev2;
            lev1 = lev1 ^ lev2;
        }

        return result;
    }
}
