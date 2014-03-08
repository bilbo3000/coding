#include <iostream> 
#include <map> 

using namespace std; 

class Solution {
public:
    int romanToInt(string s) {
        if (s.size() == 0) {
            return 0; 
        }    
        
        map<char, int> map; 
        map.insert(pair<char, int> ('I', 1)); 
        map.insert(pair<char, int> ('V', 5)); 
        map.insert(pair<char, int> ('X', 10));
        map.insert(pair<char, int> ('L', 50)); 
        map.insert(pair<char, int> ('C', 100));
        map.insert(pair<char, int> ('D', 500));
        map.insert(pair<char, int> ('M', 1000)); 
        
        int result = map[s[0]]; 
        
        for (int i = 1; i < s.size(); i++) {
            if (map[s[i]] > map[s[i - 1]]) {
                result = result - map[s[i - 1]] * 2 + map[s[i]]; 
            }
            else {
                result += map[s[i]]; 
            }
        }  
        
        return result; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    cout << sln.romanToInt("IV") << endl; 
    cout << sln.romanToInt("MMXIII") << endl;
    return 0; 
}
