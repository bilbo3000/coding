/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if (node == NULL) return NULL; 
        
        map<UndirectedGraphNode *, UndirectedGraphNode *> mapping; 
        set<UndirectedGraphNode *> history; 
        helper(node, mapping, history);
        
        return mapping[node]; 
    }
    
    void helper(UndirectedGraphNode *node, map<UndirectedGraphNode *, UndirectedGraphNode*> &mapping, set<UndirectedGraphNode *> &history) {
        if (history.find(node) != history.end()) return; 
        
        if (mapping.find(node) == mapping.end()) {
            UndirectedGraphNode * newNode = new UndirectedGraphNode(node->label); 
            mapping[node] = newNode; 
        }
        
        for (int i = 0; i < node->neighbors.size(); i++) {
            if (mapping.find(node->neighbors[i]) == mapping.end()) {
                UndirectedGraphNode * newNeighbor = new UndirectedGraphNode(node->neighbors[i]->label); 
                mapping[node->neighbors[i]] = newNeighbor; 
            }
            
            mapping[node]->neighbors.push_back(mapping[node->neighbors[i]]); 
        }
        
        history.insert(history.begin(), node); 
        
        for (int i = 0; i < node->neighbors.size(); i++) {
            helper(node->neighbors[i], mapping, history); 
        }
    }
};
