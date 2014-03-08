#include <iostream> 
#include <stack> 

using namespace std; 

class Solution {
public:
    string simplifyPath(string path) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (path.size() == 0) {
            return ""; 
        }
        
        stack<string> s; 
        
        int i = 0; 
        while (i < path.size()) {
            if (path[i] == '/'){
                int j = i + 1; 
                while (j < path.size() && path[j] != '/') {
                    j++; 
                }
                
                if (j == (i + 1)) {
                    // duplicated slash or out of bound
                    i = j; 
                }
                else {
                    string name = path.substr(i + 1, j - i - 1); 
                    if (name == "..") {
                        if (s.size() != 0) {
                            s.pop(); 
                        }
                    }
                    else if (name == ".") {
                        
                    }
                    else {
                        s.push(name);
                    }
                    
                    i = j; 
                }
            }
            else {
                i++; 
            }
        } // End of while 
        
        if (s.size() == 0) {
            return "/"; 
        }
        
        string result = ""; 
        while (s.size() != 0) {
            string temp = s.top(); 
            s.pop(); 
            result = "/" + temp + result; 
        }
        
        return result; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    cout << sln.simplifyPath("/home/dir1/../dir2/") << endl; 
    return 0; 
}
