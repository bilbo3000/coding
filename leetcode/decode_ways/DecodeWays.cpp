#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    int numDecodings(string s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.size() == 0) {
            return 0; 
        }
        
        vector<int> ways(s.size() + 1, 1);
        
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == '0') {
                ways[i] = 0; 
            }
            else {
                ways[i] = ways[i + 1]; 
                
                if (i < (s.size() - 1) && 
                    (s[i] == '1' || (s[i] == '2' && s[i + 1] <= '6'))
                ) {
                    ways[i] = ways[i + 1] + ways[i + 2]; 
                }
            }
        } 
        
        return ways[0]; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    cout << sln.numDecodings("2") << endl; 
    return 0; 
}
