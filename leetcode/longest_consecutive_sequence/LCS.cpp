#include <iostream> 
#include <vector>
#include <set>  

using namespace std; 

class Solution {
public:
    int getCount(set<int> s, int val, bool asc) {
        int count = 0; 
        while(s.find(val) != s.end()) {
            count++; 
            if (asc) {
                val++; 
            }else {
                val--; 
            }
        }
        
        return count; 
    }
    
    int longestConsecutive(vector<int> &num) {
        int result = 0; 
        set<int> s; 
        for (int i = 0; i < num.size(); i++) {
            s.insert(num[i]); 
        }
        
        for (int i = 0; i < num.size(); i++) {
            result = max(result, getCount(s, num[i], false) + getCount(s, num[i] + 1, true)); 
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
