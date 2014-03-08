class Solution {
public:
    bool isScramble(string s1, string s2) {
        if (s1.size() != s2.size()) return false; 
        if (s1 == s2) return true; 
        
        string temp1 = s1; 
        string temp2 = s2; 
        sort(temp1.begin(), temp1.end()); 
        sort(temp2.begin(), temp2.end()); 
        
        if (temp1 != temp2) return false; 
        
        // Try all split
        int size = s1.size(); 
        
        for (int i = 1; i < size; i++) {
        	string s1l = s1.substr(0, i); 
        	string s1r = s1.substr(i, size - i); 
        	
        	// Do not swap s2
        	string s2l = s2.substr(0, i); 
        	string s2r = s2.substr(i, size - i); 
        	
        	if (isScramble(s1l, s2l) && isScramble(s1r, s2r)) return true; 
        	
        	// Swap s2
        	s2l = s2.substr(0, size - i); 
        	s2r = s2.substr(size - i, i); 
        	
        	if (isScramble(s1l, s2r) && isScramble(s1r, s2l)) return true; 
        }
        
        return false; 
    }
};
