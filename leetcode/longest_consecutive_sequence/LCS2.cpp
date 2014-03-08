#include <iostream> 
#include <vector>
#include <map>  

using namespace std; 

class Solution {
public:
    int merge(map<int, int> &m, int left, int right) {
        int newRight = right + m[right] - 1; 
        int newLeft = left - m[left] + 1; 
        int newLen = newRight - newLeft + 1; 
        
        m[newRight] = newLen; 
        m[newLeft] = newLen; 
        
        return newLen; 
    }
    
    int longestConsecutive(vector<int> &num) {
        int result = 1; 
        map<int, int> m; 
        
        for (int i = 0; i < num.size(); i++) { 
            if (m.find(num[i]) != m.end()) continue; 
            
            m[num[i]] = 1;           
            if (m.find(num[i] - 1) != m.end()) {
                result = max(result, merge(m, num[i] - 1, num[i])); 
            }
            
            if (m.find(num[i] + 1) != m.end()) {
                result = max(result, merge(m, num[i], num[i] + 1)); 
            }
        }
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<int> num; 
    num.push_back(100); 
    num.push_back(4); 
    num.push_back(200); 
    num.push_back(1); 
    num.push_back(3); 
    num.push_back(2); 
    cout << sln.longestConsecutive(num) << endl; 
    return 0; 
}
