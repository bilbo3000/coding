/**
 * Given a list of division equations and results. Calculate the values of
 * each query also in the form of division. 
 * 
 * Model the problem as a graph traversal problem. Build a directed graph where 
 * a/b can be thought of as an edge a -> b where weight is the value. At the 
 * same time b/a is known too, b -> a, which is 1/x. The graph is stored in hashmap
 * where keys are names and values are lists of edges. 
 * 
 * Once graph is built, travse the graph using dfs. The parameter list carry current 
 * node, current product value, the map, and the target. Return product immediately 
 * if found target. If not found, return -1.0. 
 * 
 * Time: O(V + E)
 */ 
class Solution {
    class Edge {
        String name; 
        double val; 
        boolean visited; 
        
        Edge (String name, double val, boolean visited) {
            this.name = name; 
            this.val = val; 
            this.visited = visited; 
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> m = new HashMap<String, List<Edge>>(); 
        
        // Build the directed graph
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i]; 
            String top = equation[0]; 
            String bot = equation[1]; 
            double value = values[i]; 
            
            // top -> bot
            if (!m.containsKey(top)) {
                m.put(top, new ArrayList<Edge>());
            }
            
            m.get(top).add(new Edge(bot, value, false));
            
            // bot -> top
            if (!m.containsKey(bot)) {
                m.put(bot, new ArrayList<Edge>());
            }
            
            m.get(bot).add(new Edge(top, 1.0 / value, false)); 
        }
        
        // Calculate the results 
        int length = queries.length; 
        double[] res = new double[length];
        
        for (int i = 0; i < length; i++) {
            String[] query = queries[i]; 
            String top = query[0]; 
            String bot = query[1]; 
            
            if (!m.containsKey(top) || !m.containsKey(bot)) {
                res[i] = -1.0; 
            } else if (top == bot) {
                res[i] = 1.0; 
            } else {
                res[i] = dfs(top, 1.0, m, bot);
            }
        }
        
        return res; 
    }
    
    private double dfs(String curr, double prod, Map<String, List<Edge>> m, String target) {        
        if (curr.equals(target)) {
            // Found solution
            return prod; 
        }
        
        List<Edge> edges = m.get(curr); 
        
        for (Edge edge : edges) {
            if (!edge.visited) {
                edge.visited = true; 
                double res = dfs(edge.name, prod * edge.val, m, target);
                edge.visited = false; 
                if (res > 0) {
                    return res; 
                }
            }
        }
        
        return -1.0; 
    }
}
