#include <iostream> 
#include <vector> 
#include <map> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        map<string, vector<string> > hash;  // Key is stored string, values are strings anagram to the key
        for (int i = 0; i < strs.size(); i++) {
            string key = strs[i]; 
            sort(key.begin(), key.end());
            hash[key].push_back(strs[i]); 
        }
        
        vector<string> result; 
        for (map<string, vector<string> >::iterator it = hash.begin(); it != hash.end(); it++) {
            if ((*it).second.size() > 1) {
                for (int i = 0; i < (*it).second.size(); i++) {
                    result.push_back((*it).second[i]); 
                }
            }
        }
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<string> input; 
    input.push_back("mary");
    input.push_back("yram");  
    input.push_back("hello"); 
    
    vector<string> result = sln.anagrams(input); 
    
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " "; 
    }
    
    cout << endl; 
    
    return 0; 
}
