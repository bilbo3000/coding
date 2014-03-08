class Solution {
public:
    vector<string> changeOne(string s, unordered_set<string> &dict) {
        vector<string> result; 
        
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = 'a' + j; 
                string temp = s; 
                
                if (temp[i] != c) {
                    temp[i] = c; 
                    
                    if (dict.find(temp) != dict.end()) {  // Exist in dict
                        result.push_back(temp); 
                    }
                }
            }
        }
        
        return result; 
    }
    
    bool adjToEnd(string s, string end) {
        if (s == end) return false; 
        int diff = 0; 
        
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != end[i]) {
                diff++; 
            }
            
            if (diff > 1) return false;  
        }
        
        return diff == 1 ? true : false; 
    }
    
    vector<vector<string> > reconstruct(string s, unordered_map<string, vector<string> > &parent) {
        vector<vector<string> > result; 
        
        if (parent.find(s) == parent.end()) {  // Does not have parent 
            vector<string> temp; 
            temp.push_back(s);
            result.push_back(temp);
            return result; 
        }
        
        for (int i = 0; i < parent[s].size(); i++) {
            vector<vector<string> > temp = reconstruct(parent[s][i], parent); 
            
            for (int j = 0; j < temp.size(); j++) {
                temp[j].push_back( s);
                result.push_back(temp[j]); 
            }
        }
        
        return result; 
    }
    
    vector<vector<string>> findLadders(string start, string end, unordered_set<string> &dict) {
        vector<vector<string> > result; 
        unordered_map<string, vector<string> > parent; 
        vector<unordered_set<string> > lev(2); 
        int currlev = 0; 
        int nextlev = 1; 
        lev[currlev].insert(start);
        bool stop = false; 
        
        while (!stop && lev[currlev].size() != 0) {
            // Erase from dict, must do it before moving on
            for (auto it = lev[currlev].begin(); it != lev[currlev].end(); it++) {
                dict.erase(*it); 
            }
            
            for (auto it = lev[currlev].begin(); it != lev[currlev].end(); it++) {
                if (!adjToEnd(*it, end)) {  // Not adjacent to end, collect children
                    vector<string> children = changeOne(*it, dict); 
                    
                    for (int j = 0; j < children.size(); j++) {
                        parent[children[j]].push_back(*it);  // Update parents 
                        lev[nextlev].insert(children[j]); 
                    }
                }
                else {  // Adjacent to end 
                    stop = true; 
                    parent[end].push_back(*it); 
                }
            }
            
            lev[currlev].clear();  
            currlev = !currlev; 
            nextlev = !nextlev; 
        }
        
        if (stop) {
            result = reconstruct(end, parent); 
        }
        
        return result; 
    }
};
